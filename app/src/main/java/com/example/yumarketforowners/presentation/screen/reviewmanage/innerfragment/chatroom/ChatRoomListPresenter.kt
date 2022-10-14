package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom

import android.util.Log
import com.example.yumarketforowners.R
import com.example.yumarketforowners.domain.usecase.chatroom.GetChatRooms
import com.example.yumarketforowners.presentation.mapper.chatroom.toChatRoomUiState
import com.example.yumarketforowners.presentation.viewholder.CellType
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.screen.base.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class ChatRoomListPresenter @Inject constructor(
    private val view: ChatRoomListView,
    private val getChatRooms: GetChatRooms,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

    fun requestData(marketId: Long) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            // TODO: 2022.06.04 get all data by market id
            /* TODO: 2022-09-21 수 01:35, error 처리 구현 */
            val result = getChatRooms(marketId = marketId)?.let {
                Result.Success(data = it.map { chatRoom ->
                    chatRoom.toChatRoomUiState(
                        onClicked = { Log.d("TAG", "onClicked: ${chatRoom.id}") },
                        onRemoveClicked = { Log.d("TAG", "onRemoveClicked: ${chatRoom.id}") }
                    )
                })
            } ?: Result.Error(R.string.error_placeholder)

            view.loading(isLoading = false)

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
    val unreadMessageCount: Int,
    val onClicked: () -> Unit,
    val onRemoveClicked: () -> Unit
) : BaseViewHolderState(id, CellType.CHAT_ROOM_CELL)