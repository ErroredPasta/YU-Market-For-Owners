package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review

import com.example.yumarketforowners.coroutine.TestCoroutineRule
import com.example.yumarketforowners.domain.usecase.review.GetReviewsUseCase
import com.example.yumarketforowners.entity.createReview
import com.example.yumarketforowners.presentation.mapper.review.toReviewUiState
import io.mockk.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Provider


@ExperimentalCoroutinesApi
class ReviewManagePresenterTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var sut: ReviewManagePresenter

    // region test doubles =========================================================================
    private lateinit var viewMock: ReviewInnerFragment
    private lateinit var getReviewsUseCaseMock: GetReviewsUseCase
    private lateinit var scopeProviderMock: Provider<CoroutineScope>
    // endregion test doubles ======================================================================

    // region constants ============================================================================
    private val testMarketId = 0L
    // endregion constants =========================================================================

    @Before
    fun setup() {
        viewMock = mockk(relaxed = true)
        getReviewsUseCaseMock = mockk()
        scopeProviderMock = mockk()

        sut = ReviewManagePresenter(
            view = viewMock,
            getReviewsUseCase = getReviewsUseCaseMock,
            scopeProvider = scopeProviderMock
        )

        every { scopeProviderMock.get() } returns TestScope()
    }

    @Test
    fun `on request, show loading then hide when request complete`() = runTest {
        // arrange
        getReviewsReturns()

        // act
        sut.requestData(marketId = testMarketId)
        advanceUntilIdle()

        // assert
        verifyOrder {
            viewMock.loading(isLoading = true)
            viewMock.loading(isLoading = false)
        }
    }

    @Test
    fun `request reviews, on success`() = runTest {
        // arrange
        val expected = getReviewsReturns()

        // act
        sut.requestData(marketId = testMarketId)
        advanceUntilIdle()

        // assert
        verify { viewMock.onRequestDataSuccess(expected) }
    }

    @Test
    fun `request reviews, on error`() = runTest {
        // arrange
        getReviewsFailed()

        // act
        sut.requestData(marketId = testMarketId)
        advanceUntilIdle()

        // assert
        verify { viewMock.onRequestDataError(any()) }
    }

    // region helper methods =======================================================================

    private fun getReviewsReturns(): List<ReviewUiState> {
        val returnValue = createReviewList()

        coEvery { getReviewsUseCaseMock(marketId = any()) } returns returnValue

        return returnValue.map {
            it.toReviewUiState(
                onReplyClicked = {}
            )
        }
    }

    private fun getReviewsFailed() {
        coEvery { getReviewsUseCaseMock(marketId = any()) } returns null
    }

    private fun createReviewList() = (1..10).map {
        createReview(it)
    }

    // endregion helper methods ====================================================================
}