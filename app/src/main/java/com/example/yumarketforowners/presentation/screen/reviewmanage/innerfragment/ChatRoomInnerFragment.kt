package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment

import android.widget.Toast
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.recyclerview.listener.reviewmanage.ChatRoomViewHolderListener
import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoom
import com.example.yumarketforowners.presentation.screen.reviewmanage.ReviewManageContract
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChatRoomInnerFragment : BaseReviewInnerFragment<ChatRoom>() {
    @Inject
    lateinit var presenter: ReviewManageContract.Presenter<ChatRoom>

    override val adapter: ModelRecyclerAdapter<ChatRoom> by lazy {
        ModelRecyclerAdapter(
            emptyList(),
            object : ChatRoomViewHolderListener {
                override fun onClicked(chatRoom: ChatRoom) {
                    // TODO: 2022.07.10 start chat room activity
                    Toast.makeText(context, "$chatRoom clicked", Toast.LENGTH_SHORT).show()
                }

                override fun onRemoveClicked(chatRoom: ChatRoom) {
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