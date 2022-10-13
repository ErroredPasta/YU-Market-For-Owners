package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom

import android.widget.Toast
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.recyclerview.listener.reviewmanage.ChatRoomViewHolderListener
import com.example.yumarketforowners.domain.model.chatroom.ChatRoom
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.BaseReviewInnerFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChatRoomInnerFragment : BaseReviewInnerFragment<ChatRoomUiState>() {
    @Inject
    lateinit var presenter: ChatRoomPresenter

    override val adapter: ModelRecyclerAdapter<ChatRoomUiState> by lazy {
        ModelRecyclerAdapter(
            object : ChatRoomViewHolderListener {
                override fun onClicked(chatRoom: ChatRoomUiState) {
                    // TODO: 2022.07.10 start chat room activity
                    Toast.makeText(context, "$chatRoom clicked", Toast.LENGTH_SHORT).show()
                }

                override fun onRemoveClicked(chatRoom: ChatRoomUiState) {
                    // TODO: 2022.07.10 handle remove
                    Toast.makeText(context, "$chatRoom remove clicked", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    override fun requestData() {
        // TODO: 2022.07.10 request by market id
        presenter.requestData(0)
    }
}