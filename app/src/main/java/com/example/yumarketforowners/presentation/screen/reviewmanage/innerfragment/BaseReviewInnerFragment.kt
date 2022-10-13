package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.yumarketforowners.databinding.InnerFragmentReviewOrChatRoomListBinding
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.extension.addItemDivider
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
import com.example.yumarketforowners.presentation.screen.reviewmanage.ReviewOrChatRoomType
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.ChatRoomInnerFragment
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review.ReviewInnerFragment

abstract class BaseReviewInnerFragment<M : BaseViewHolderState> :
    BaseFragment<InnerFragmentReviewOrChatRoomListBinding>() {

    companion object {
        fun newInstance(type: ReviewOrChatRoomType) = when (type) {
            ReviewOrChatRoomType.REVIEW -> ReviewInnerFragment()
            ReviewOrChatRoomType.CHAT_ROOM -> ChatRoomInnerFragment()
        }
    }

    protected abstract val adapter: ModelRecyclerAdapter<M>

    override fun initState() {
        binding.reviewOrChatRoomListRecyclerView.run {
            this.adapter = this@BaseReviewInnerFragment.adapter
            addItemDivider(LinearLayout.VERTICAL)
        }

        requestData()
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = InnerFragmentReviewOrChatRoomListBinding.inflate(inflater, container, false)

    abstract fun requestData()

    fun loading(show: Boolean) {
        // TODO: 2022.06.04 handle loading
    }

    fun onRequestDataSuccess(data: List<M>) {
        adapter.submitList(data)
    }

    fun onRequestDataError(@StringRes errorMessage: Int) {
        Toast.makeText(context, getText(errorMessage), Toast.LENGTH_SHORT).show()
    }
}