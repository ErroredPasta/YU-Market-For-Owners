package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom

import com.example.yumarketforowners.domain.usecase.chatroom.GetChatRoomsUseCase
import com.example.yumarketforowners.domain.usecase.chatroom.RemoveChatRoomUseCase
import com.example.yumarketforowners.presentation.mapper.chatroom.toChatRoomUiState
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.viewholder.CellType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class ChatRoomListPresenter(
    private val view: ChatRoomListView,
    private val getChatRoomsUseCase: GetChatRoomsUseCase,
    private val removeChatRoomUseCase: RemoveChatRoomUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(view, scopeProvider) {

    fun requestChatRooms(marketId: Long) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            /* TODO: 2022-09-21 수 01:35, error 처리 구현 */
            val result = getChatRoomsUseCase(marketId = marketId).map { chatRoom ->
                chatRoom.toChatRoomUiState(
                    onClicked = { view.navigateToChatRoomScreen(chatRoom.id) },
                    onRemoveClicked = {
                        coroutineScope.launch {
                            removeChatRoomUseCase(chatRoom.id)
                            requestChatRooms(marketId = marketId)
                        }
                    }
                )
            }

            view.loading(isLoading = false)

            view.onRequestChatRoomsSuccess(result)
        }
    }
}

data class ChatRoomUiState(
    override val id: Long,
    val opponentName: String,
    val opponentImageUrl: String?,
    val lastMessage: String,
    val createdTime: Long,
    val unreadMessageCount: Int,
    val onClicked: () -> Unit,
    val onRemoveClicked: () -> Unit
) : BaseViewHolderState(id, CellType.CHAT_ROOM_CELL)