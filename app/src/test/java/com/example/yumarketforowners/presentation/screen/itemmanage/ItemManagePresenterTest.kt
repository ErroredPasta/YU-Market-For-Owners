package com.example.yumarketforowners.presentation.screen.itemmanage
//
//import com.example.yumarketforowners.coroutine.TestCoroutineRule
//import com.example.yumarketforowners.domain.model.item.Item
//import com.example.yumarketforowners.domain.usecase.item.GetItemsUseCase
//import com.example.yumarketforowners.entity.createItem
//import com.example.yumarketforowners.presentation.mapper.item.toItem
//import com.google.common.truth.Truth.assertThat
//import io.mockk.*
//import kotlinx.coroutines.*
//import kotlinx.coroutines.test.TestScope
//import kotlinx.coroutines.test.advanceUntilIdle
//import kotlinx.coroutines.test.runTest
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import javax.inject.Provider
//
//
//@ExperimentalCoroutinesApi
//class ItemManagePresenterTest {
//
//    @get:Rule
//    val testCoroutineRule = TestCoroutineRule()
//
//    private lateinit var sut: ItemManagePresenter
//
//    // region test doubles =========================================================================
//    private lateinit var viewMock: ItemManageView
//    private lateinit var getItemsUseCaseMock: GetItemsUseCase
//    private lateinit var scopeProviderMock: Provider<CoroutineScope>
//    // endregion test doubles ======================================================================
//
//    // region constants ============================================================================
//    private val testMarketId = 0L
//    // endregion constants =========================================================================
//
//    @Before
//    fun setup() {
//        viewMock = mockk(relaxed = true)
//        getItemsUseCaseMock = mockk()
//        scopeProviderMock = mockk()
//
//        sut = ItemManagePresenter(
//            view = viewMock,
//            getItemsUseCase = getItemsUseCaseMock,
//            scopeProvider = scopeProviderMock,
//        )
//
//        every { scopeProviderMock.get() } returns TestScope() + SupervisorJob()
//    }
//
//    @Test
//    fun `on request items, show loading then hide when complete`() = runTest {
//        // arrange
//        getItemsReturns(available = true)
//
//        // act
//        sut.requestData(marketId = testMarketId, available = true)
//        advanceUntilIdle()
//
//        // assert
//        verifyOrder {
//            viewMock.loading(isLoading = true)
//            viewMock.loading(isLoading = false)
//        }
//    }
//
//    @Test
//    fun `request available items, on success`() = runTest {
//        // arrange
//        val expected = getItemsReturns(available = true)
//
//        // act
//        sut.requestData(marketId = testMarketId, available = true)
//        advanceUntilIdle()
//
//        // assert
//        val slot = slot<List<ItemUiState>>()
//        verify { viewMock.onRequestDataSuccess(capture(slot)) }
//
//        val capturedValue = slot.captured.map { it.toItem() }
//        assertThat(capturedValue).isEqualTo(expected)
//    }
//
//    @Test
//    fun `request available items, on error`() = runTest {
//        // arrange
//        getItemsFailed()
//
//        // act
//        sut.requestData(marketId = testMarketId, available = true)
//        advanceUntilIdle()
//
//        // assert
//        verify { viewMock.onError(any()) }
//    }
//
//    @Test
//    fun `request unavailable items, on success`() = runTest {
//        // arrange
//        val expected = getItemsReturns(available = false)
//
//        // act
//        sut.requestData(marketId = testMarketId, available = false)
//        advanceUntilIdle()
//
//        // assert
//        val slot = slot<List<ItemUiState>>()
//        verify { viewMock.onRequestDataSuccess(capture(slot)) }
//
//        val capturedValue = slot.captured.map { it.toItem() }
//        assertThat(capturedValue).isEqualTo(expected)
//    }
//
//    @Test
//    fun `request unavailable items, on error`() = runTest {
//        // arrange
//        getItemsFailed()
//
//        // act
//        sut.requestData(marketId = testMarketId, available = false)
//        advanceUntilIdle()
//
//        // assert
//        verify { viewMock.onError(any()) }
//    }
//
//    // region helper methods =======================================================================
//
//    private fun getItemsReturns(available: Boolean): List<Item> {
//        val returnValue = createItemList(available = available)
//
//        coEvery {
//            getItemsUseCaseMock(marketId = any(), available = available)
//        } returns returnValue
//
//        return returnValue
//    }
//
//    private fun getItemsFailed() {
//        /* TODO: 2022-10-22 토 21:40, throw proper exception */
//        coEvery {
//            getItemsUseCaseMock(marketId = any(), available = any())
//        } throws RuntimeException()
//    }
//
//    private fun createItemList(available: Boolean) = (1..10).map {
//        createItem(it, available = available)
//    }
//
//    // endregion helper methods ====================================================================
//}