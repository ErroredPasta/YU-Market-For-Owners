package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.yumarketforowners.databinding.InnerFragmentReviewListBinding
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.extension.addItemDivider
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.BaseReviewInnerFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ReviewInnerFragment : BaseFragment<InnerFragmentReviewListBinding>(), BaseReviewInnerFragment,
    ReviewListView {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = InnerFragmentReviewListBinding.inflate(inflater, container, false)

    @Inject
    lateinit var presenter: ReviewManagePresenter

    private val adapter: ModelRecyclerAdapter<ReviewUiState> by lazy { ModelRecyclerAdapter() }

    override fun initState() {
        binding.reviewOrChatRoomListRecyclerView.apply {
            this.adapter = this@ReviewInnerFragment.adapter
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

    override fun onRequestDataSuccess(data: List<ReviewUiState>) {
        adapter.submitList(data)
    }

    override fun onRequestDataError(@StringRes errorMessage: Int) {
        Toast.makeText(context, getText(errorMessage), Toast.LENGTH_SHORT).show()
    }
}
