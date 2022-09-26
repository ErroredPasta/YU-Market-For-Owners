package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom

import com.example.yumarketforowners.R
import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoom
import com.example.yumarketforowners.domain.usecase.chatroom.GetChatRooms
import com.example.yumarketforowners.presentation.screen.base.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class ChatRoomPresenter @Inject constructor(
    private val view: ChatRoomInnerFragment,
    private val getChatRooms: GetChatRooms,
    private val scopeProvider: Provider<CoroutineScope>
) {
    private val coroutineScope get() = scopeProvider.get()

    fun requestData(marketId: Long) {
        coroutineScope.launch {
            view.loading(show = true)
            // TODO: 2022.06.04 get all data by market id
            /* TODO: 2022-09-21 수 01:35, error 처리 구현 */
            val result = getChatRooms(marketId = marketId)?.let {
                State.Success(data = it)
            } ?: State.Error(R.string.error_placeholder)

            view.loading(show = false)

            @Suppress("UNCHECKED_CAST")
            when (result) {
                is State.Success<*> -> view.onRequestDataSuccess(result.data as List<ChatRoom>)
                is State.Error -> view.onRequestDataError(result.errorMessage)
            }
        }
    }
}