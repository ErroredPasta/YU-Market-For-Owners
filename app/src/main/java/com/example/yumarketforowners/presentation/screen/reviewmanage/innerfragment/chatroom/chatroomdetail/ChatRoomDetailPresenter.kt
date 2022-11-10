package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.chatroomdetail

import com.example.yumarketforowners.domain.model.chatroom.Chat
import com.example.yumarketforowners.domain.usecase.chatroom.GetChatsByChatRoomIdUseCase
import com.example.yumarketforowners.domain.usecase.chatroom.SendChatUseCase
import com.example.yumarketforowners.presentation.mapper.chatroom.toChatUiState
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import com.example.yumarketforowners.presentation.viewholder.CellType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Provider

class ChatRoomDetailPresenter(
    private val view: ChatRoomDetailView,
    private val getChatsByChatRoomIdUseCase: GetChatsByChatRoomIdUseCase,
    private val sendChatUseCase: SendChatUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(view, scopeProvider) {

    fun requestChats(chatRoomId: Long) {
        getChatsByChatRoomIdUseCase(chatRoomId = chatRoomId).onStart {
            view.loading(isLoading = true)
        }.onEach { chats ->
            view.onRequestChatsSuccess(chats = chats.map { chat ->
                chat.toChatUiState(
                    cellType = if (chat.senderId == 0L) CellType.MY_CHAT_CELL else CellType.OPPONENT_CHAT_CELL
                )
            })
        }.onCompletion {
            view.loading(isLoading = false)
        }.catch {
            view.onError(it)
        }.launchIn(coroutineScope)
    }

    fun sendChat(chatRoomId: Long, chat: Chat) {
        coroutineScope.launch {
            sendChatUseCase(chatRoomId = chatRoomId, chat = chat)
            view.afterSendingMessage()
        }
    }
}