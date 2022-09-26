package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom

import com.example.yumarketforowners.coroutine.TestCoroutineRule
import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoom
import com.example.yumarketforowners.domain.usecase.chatroom.GetChatRooms
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
class ChatRoomPresenterTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var sut: ChatRoomPresenter

    // region test doubles =========================================================================
    private lateinit var viewMock: ChatRoomInnerFragment
    private lateinit var getChatRoomsMock: GetChatRooms
    private lateinit var scopeProviderMock: Provider<CoroutineScope>
    // endregion test doubles ======================================================================

    // region constants ============================================================================
    private val testMarketId = 0L
    // endregion constants =========================================================================

    @Before
    fun setup() {
        viewMock = mockk(relaxed = true)
        getChatRoomsMock = mockk()
        scopeProviderMock = mockk()

        sut = ChatRoomPresenter(
            view = viewMock,
            getChatRooms = getChatRoomsMock,
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
            viewMock.loading(show = true)
            viewMock.loading(show = false)
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
        verify { viewMock.onRequestDataSuccess(expected) }
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

        coEvery { getChatRoomsMock(marketId = any()) } returns returnValue

        return returnValue
    }

    private fun getChatRoomsFailed() {
        coEvery { getChatRoomsMock(marketId = any()) } returns null
    }

    private fun createChatRoomList() = (1..10).map {
        ChatRoom(
            id = it.toLong(),
            opponentName = "opponentName $it",
            opponentImageUrl = "opponentImageUrl $it",
            lastMessage = "lastMessage $it",
            createdTime = it.toLong(),
            unreadMessageCount = it
        )
    }
    // endregion helper methods ====================================================================

    // region test double classes ==================================================================

    // endregion test doubles classes ==============================================================
}