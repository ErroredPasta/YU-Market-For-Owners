package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.domain.model.BaseModel
import com.example.yumarketforowners.databinding.InnerFragmentReviewOrChatRoomListBinding
import com.example.yumarketforowners.presentation.extension.addItemDivider
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
import com.example.yumarketforowners.presentation.screen.reviewmanage.ReviewManageContract
import com.example.yumarketforowners.presentation.screen.reviewmanage.ReviewOrChatRoomType

abstract class BaseReviewInnerFragment<M : BaseModel> :
    BaseFragment<InnerFragmentReviewOrChatRoomListBinding>(),
    ReviewManageContract.View<M> {

    companion object {
        fun newInstance(type: ReviewOrChatRoomType) = if (type == ReviewOrChatRoomType.REVIEW) {
            ReviewInnerFragment()
        } else {
            ChatRoomInnerFragment()
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

    override fun loading(show: Boolean) {
        // TODO: 2022.06.04 handle loading
    }

    override fun onRequestDataSuccess(data: List<M>) {
        adapter.submitList(data)
    }

    override fun onRequestDataError(@StringRes errorMessage: Int) {
        Toast.makeText(context, getText(errorMessage), Toast.LENGTH_SHORT).show()
    }
}