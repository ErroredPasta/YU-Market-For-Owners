package com.example.yumarketforowners.marketmanage.notice.presentation.screen.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import com.example.yumarketforowners.databinding.FragmentNoticeListBinding
import com.example.yumarketforowners.core.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.core.presentation.extension.addItemDivider
import com.example.yumarketforowners.core.presentation.base.BaseFragment
import com.example.yumarketforowners.marketmanage.notice.presentation.viewholder.NoticeUiState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NoticeListFragment : BaseFragment<FragmentNoticeListBinding>(), NoticeListView {

    override fun getViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentNoticeListBinding.inflate(inflater, container, false)

    private val navController by lazy { findNavController() }

    @Inject
    lateinit var presenter: NoticeListPresenter

    private val adapter = ModelRecyclerAdapter<NoticeUiState>()

    override fun initState() {
        super.initState()
        binding.noticeRecyclerView.apply {
            adapter = this@NoticeListFragment.adapter
            addItemDivider(LinearLayout.VERTICAL)
        }

        presenter.requestNotices()
    }

    override fun onRequestNoticeListSuccess(notices: List<NoticeUiState>) {
        adapter.submitList(notices)
    }

    override fun navigateToNoticeDetailScreen(noticeId: Long) {
        navController.navigate(
            NoticeListFragmentDirections.actionNoticeListFragmentToNoticeDetailFragment(noticeId = noticeId)
        )
    }

    override fun loading(isLoading: Boolean) {
        /* TODO: 2022-11-3 목 13:43, implement loading */
    }

    override fun onError(throwable: Throwable) {
        /* TODO: 2022-11-3 목 13:43, implement error handling */
        throwable.message?.let { showToast(message = it) }
    }
}