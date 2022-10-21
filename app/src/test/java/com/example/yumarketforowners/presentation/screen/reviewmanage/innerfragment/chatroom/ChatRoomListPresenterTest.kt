package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom

import com.example.yumarketforowners.coroutine.TestCoroutineRule
import com.example.yumarketforowners.domain.model.chatroom.ChatRoom
import com.example.yumarketforowners.domain.usecase.chatroom.GetChatRoomsUseCase
import com.example.yumarketforowners.entity.createChatRoom
import com.example.yumarketforowners.presentation.mapper.chatroom.toChatRoom
import com.example.yumarketforowners.presentation.mapper.chatroom.toChatRoomUiState
import com.google.common.truth.Truth.assertThat
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
class ChatRoomListPresenterTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var sut: ChatRoomListPresenter

    // region test doubles =========================================================================
    private lateinit var viewMock: ChatRoomInnerFragment
    private lateinit var getChatRoomsUseCaseMock: GetChatRoomsUseCase
    private lateinit var scopeProviderMock: Provider<CoroutineScope>
    // endregion test doubles ======================================================================

    // region constants ============================================================================
    private val testMarketId = 0L
    // endregion constants =========================================================================

    @Before
    fun setup() {
        viewMock = mockk(relaxed = true)
        getChatRoomsUseCaseMock = mockk()
        scopeProviderMock = mockk()

        sut = ChatRoomListPresenter(
            view = viewMock,
            getChatRoomsUseCase = getChatRoomsUseCaseMock,
            scopeProvider = scopeProviderMock
        )

        every { scopeProviderMock.get() } returns TestScope()
    }

    @Test
    fun `on request, show loading then hide when request complete`() = runTest {
        // arrange
        getChatRoomsReturns()

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
    fun `request chat rooms, on success`() = runTest {
        // arrange
        val expected = getChatRoomsReturns()

        // act
        sut.requestData(marketId = testMarketId)
        advanceUntilIdle()

        // assert
        val slot = slot<List<ChatRoomUiState>>()
        verify { viewMock.onRequestDataSuccess(capture(slot)) }

        val capturedValue = slot.captured.map { it.toChatRoom() }
        assertThat(capturedValue).isEqualTo(expected)
    }

    @Test
    fun `request chat rooms, on error`() = runTest {
        // arrange
        getChatRoomsFailed()

        // act
        sut.requestData(marketId = testMarketId)
        advanceUntilIdle()

        // assert
        verify { viewMock.onRequestDataError(any()) }
    }

    // region helper methods =======================================================================

    private fun getChatRoomsReturns(): List<ChatRoom> {
        val returnValue = createChatRoomList()

        coEvery { getChatRoomsUseCaseMock(marketId = any()) } returns returnValue

        return returnValue
    }

    private fun getChatRoomsFailed() {
        coEvery { getChatRoomsUseCaseMock(marketId = any()) } returns null
    }

    private fun createChatRoomList() = (1..10).map {
        createChatRoom(it)
    }

    // endregion helper methods ====================================================================
}