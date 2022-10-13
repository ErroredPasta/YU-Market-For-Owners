package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom

import com.example.yumarketforowners.R
import com.example.yumarketforowners.domain.usecase.chatroom.GetChatRooms
import com.example.yumarketforowners.presentation.mapper.chatroom.toChatRoomUiState
import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.screen.base.Result
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
                Result.Success(data = it.map { chatRoom -> chatRoom.toChatRoomUiState() })
            } ?: Result.Error(R.string.error_placeholder)

            view.loading(show = false)

            when (result) {
                is Result.Success -> view.onRequestDataSuccess(result.data)
                is Result.Error -> view.onRequestDataError(result.errorMessage)
            }
        }
    }
}

data class ChatRoomUiState(
    override val id: Long,
    val opponentName: String,
    val opponentImageUrl: String?,
    val lastMessage: String,
    val createdTime: Long,
    val unreadMessageCount: Int
) : BaseViewHolderState(id, CellType.CHAT_ROOM_CELL)