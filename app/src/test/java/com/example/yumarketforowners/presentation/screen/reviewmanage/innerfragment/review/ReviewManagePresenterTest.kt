package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review

import com.example.yumarketforowners.coroutine.TestCoroutineRule
import com.example.yumarketforowners.domain.model.itemmanage.Item
import com.example.yumarketforowners.domain.model.orderlist.DeliveryType
import com.example.yumarketforowners.domain.model.orderlist.Order
import com.example.yumarketforowners.domain.model.orderlist.OrderState
import com.example.yumarketforowners.domain.model.reviewmanage.Review
import com.example.yumarketforowners.domain.usecase.review.GetReviews
import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
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
    private lateinit var getReviewsMock: GetReviews
    private lateinit var scopeProviderMock: Provider<CoroutineScope>
    // endregion test doubles ======================================================================

    // region constants ============================================================================
    private val testMarketId = 0L
    // endregion constants =========================================================================

    @Before
    fun setup() {
        viewMock = mockk(relaxed = true)
        getReviewsMock = mockk()
        scopeProviderMock = mockk()

        sut = ReviewManagePresenter(
            view = viewMock,
            getReviews = getReviewsMock,
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
            viewMock.loading(show = true)
            viewMock.loading(show = false)
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
    private fun getReviewsReturns(): List<Review> {
        val returnValue = createReviewList()

        coEvery { getReviewsMock(marketId = any()) } returns returnValue

        return returnValue
    }

    private fun getReviewsFailed() {
        coEvery { getReviewsMock(marketId = any()) } returns null
    }

    private fun createReviewList() = (1..10).map {
        Review(
            id = it.toLong(),
            writer = "writer $it",
            profileImageUrl = "profileImageUrl $it",
            content = "content $it",
            order = Order(
                id = it.toLong(),
                orderItems = (it..it + 1).map { itemIndex ->
                    Item(
                        id = itemIndex.toLong(),
                        name = "name $itemIndex",
                        count = itemIndex,
                        price = itemIndex,
                        saleRatio = itemIndex,
                        imageUrl = "imageUrl $itemIndex",
                        available = true,
                        cellType = CellType.ORDER_ITEM_CELL
                    )
                },
                orderId = "order $it",
                deliveryType = DeliveryType.values()[it % 3],
                orderTime = it.toLong(),
                telePhoneNumber = "telePhoneNumber $it",
                request = "request $it",
                orderState = OrderState.values()[it % 3]
            ),
            writeTime = it.toLong()
        )
    }

    // endregion helper methods ====================================================================
}