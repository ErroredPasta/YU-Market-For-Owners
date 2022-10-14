package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.yumarketforowners.databinding.InnerFragmentChatRoomListBinding
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.extension.addItemDivider
import com.example.yumarketforowners.presentation.recyclerview.listener.reviewmanage.ChatRoomViewHolderListener
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.BaseReviewInnerFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChatRoomInnerFragment : BaseFragment<InnerFragmentChatRoomListBinding>(),
    BaseReviewInnerFragment, ChatRoomListView {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = InnerFragmentChatRoomListBinding.inflate(inflater, container, false)

    @Inject
    lateinit var presenter: ChatRoomListPresenter

    private val adapter: ModelRecyclerAdapter<ChatRoomUiState> by lazy {
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

    override fun initState() {
        binding.chatRoomListRecyclerView.apply {
            this.adapter = this@ChatRoomInnerFragment.adapter
            addItemDivider(LinearLayout.VERTICAL)
        }

        requestData()
    }

    private fun requestData() {
        // TODO: 2022.07.10 request by market id
        presenter.requestData(0)
    }

    override fun loading(isLoading: Boolean) {
        // TODO: 2022.06.04 handle loading
    }

    override fun onRequestDataSuccess(data: List<ChatRoomUiState>) {
        adapter.submitList(data)
    }

    override fun onRequestDataError(@StringRes errorMessage: Int) {
        Toast.makeText(context, getText(errorMessage), Toast.LENGTH_SHORT).show()
    }
}