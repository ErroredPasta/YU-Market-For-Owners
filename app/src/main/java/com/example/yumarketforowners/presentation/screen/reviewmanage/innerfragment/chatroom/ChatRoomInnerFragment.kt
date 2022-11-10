package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.yumarketforowners.R
import com.example.yumarketforowners.databinding.InnerFragmentChatRoomListBinding
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.extension.addItemDivider
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.BaseReviewInnerFragment
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.chatroomdetail.ChatRoomDetailActivity
import com.example.yumarketforowners.presentation.viewholder.reviewmanage.ChatRoomUiState
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

    @Inject
    lateinit var navController: NavController

    private val adapter: ModelRecyclerAdapter<ChatRoomUiState> by lazy { ModelRecyclerAdapter() }

    override fun initState() {
        binding.chatRoomListRecyclerView.apply {
            this.adapter = this@ChatRoomInnerFragment.adapter
            addItemDivider(LinearLayout.VERTICAL)
        }

        /* TODO: 2022-10-25 화 00:19, request chat rooms using market id */
        presenter.requestChatRooms(marketId = 0)
    }

    override fun loading(isLoading: Boolean) {
        // TODO: 2022.06.04 handle loading
    }

    override fun onRequestChatRoomsSuccess(chatRooms: List<ChatRoomUiState>) {
        adapter.submitList(chatRooms)
    }

    override fun onError(throwable: Throwable) {
        /* TODO: 2022-10-22 토 20:30, implement error handling */
        throwable.message?.let { showToast(message = it) }
    }

    override fun navigateToChatRoomScreen(chatRoomId: Long) {
        navController.navigate(
            R.id.action_reviewManageFragment_to_chatRoomDetailActivity,
            bundleOf(ChatRoomDetailActivity.KEY_CHAT_R0OM_ID to chatRoomId)
        )
    }
}