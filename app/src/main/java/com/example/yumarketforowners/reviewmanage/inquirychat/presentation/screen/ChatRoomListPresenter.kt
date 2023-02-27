package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.GetChatRoomsUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.RemoveChatRoomUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.mapper.toChatRoomUiState
import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import com.example.yumarketforowners.core.util.runCoroutineCatching
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class ChatRoomListPresenter(
    private val view: ChatRoomListView,
    private val getChatRoomsUseCase: GetChatRoomsUseCase,
    private val removeChatRoomUseCase: RemoveChatRoomUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

    fun requestChatRooms(marketId: Long) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            /* TODO: 2022-09-21 수 01:35, error 처리 구현 */
            runCoroutineCatching {
                getChatRoomsUseCase(marketId = marketId).map { chatRoom ->
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
            }.onSuccess { result ->
                view.onRequestChatRoomsSuccess(result)
            }.onFailure { cause ->
                view.onError(cause)
            }

            view.loading(isLoading = false)

        }
    }
}