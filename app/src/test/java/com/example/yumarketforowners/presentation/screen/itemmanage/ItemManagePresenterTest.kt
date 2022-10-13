package com.example.yumarketforowners.presentation.screen.itemmanage

import com.example.yumarketforowners.coroutine.TestCoroutineRule
import com.example.yumarketforowners.domain.usecase.item.GetItems
import com.example.yumarketforowners.entity.createItem
import com.example.yumarketforowners.presentation.mapper.item.toItemUiState
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
class ItemManagePresenterTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var sut: ItemManagePresenter

    // region test doubles =========================================================================
    private lateinit var viewMock: ItemListInnerFragment
    private lateinit var getItemsMock: GetItems
    private lateinit var scopeProviderMock: Provider<CoroutineScope>
    // endregion test doubles ======================================================================

    // region constants ============================================================================
    private val testMarketId = 0L
    // endregion constants =========================================================================

    @Before
    fun setup() {
        viewMock = mockk(relaxed = true)
        getItemsMock = mockk()
        scopeProviderMock = mockk()

        sut = ItemManagePresenter(
            view = viewMock,
            getItems = getItemsMock,
            scopeProvider = scopeProviderMock
        )

        every { scopeProviderMock.get() } returns TestScope()
    }

    @Test
    fun `on request items, show loading then hide when complete`() = runTest {
        // arrange
        getItemsReturns(available = true)

        // act
        sut.requestData(marketId = testMarketId, available = true)
        advanceUntilIdle()

        // assert
        verifyOrder {
            viewMock.loading(show = true)
            viewMock.loading(show = false)
        }
    }

    @Test
    fun `request available items, on success`() = runTest {
        // arrange
        val expected = getItemsReturns(available = true)

        // act
        sut.requestData(marketId = testMarketId, available = true)
        advanceUntilIdle()

        // assert
        verify { viewMock.onRequestDataSuccess(expected) }
    }

    @Test
    fun `request available items, on error`() = runTest {
        // arrange
        getItemsFailed()

        // act
        sut.requestData(marketId = testMarketId, available = true)
        advanceUntilIdle()

        // assert
        verify { viewMock.onRequestDataError(any()) }
    }

    @Test
    fun `request unavailable items, on success`() = runTest {
        // arrange
        val expected = getItemsReturns(available = false)

        // act
        sut.requestData(marketId = testMarketId, available = false)
        advanceUntilIdle()

        // assert
        verify { viewMock.onRequestDataSuccess(expected) }
    }

    @Test
    fun `request unavailable items, on error`() = runTest {
        // arrange
        getItemsFailed()

        // act
        sut.requestData(marketId = testMarketId, available = false)
        advanceUntilIdle()

        // assert
        verify { viewMock.onRequestDataError(any()) }
    }

    // region helper methods =======================================================================

    private fun getItemsReturns(available: Boolean): List<ItemUiState> {
        val returnValue = createItemList(available = available)

        coEvery {
            getItemsMock(marketId = any(), available = available)
        } returns returnValue

        return returnValue.map { it.toItemUiState() }
    }

    private fun getItemsFailed() {
        coEvery {
            getItemsMock(marketId = any(), available = any())
        } returns null
    }

    private fun createItemList(available: Boolean) = (1..10).map {
        createItem(it, available = available)
    }

    // endregion helper methods ====================================================================
}