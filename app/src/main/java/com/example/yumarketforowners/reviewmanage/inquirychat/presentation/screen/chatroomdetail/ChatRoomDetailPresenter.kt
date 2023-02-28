package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen.chatroomdetail

import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import com.example.yumarketforowners.core.presentation.viewholder.CellType
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.model.Chat
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.GetChatsByChatRoomIdUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.SendChatUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.mapper.toChatUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class ChatRoomDetailPresenter @Inject constructor(
    private val view: ChatRoomDetailView,
    private val getChatsByChatRoomIdUseCase: GetChatsByChatRoomIdUseCase,
    private val sendChatUseCase: SendChatUseCase,
    @LifeCycleScope(LifeCycleScopeType.ACTIVITY) scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

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