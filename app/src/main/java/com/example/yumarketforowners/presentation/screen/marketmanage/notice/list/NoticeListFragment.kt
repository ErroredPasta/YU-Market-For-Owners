package com.example.yumarketforowners.presentation.screen.marketmanage.notice.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import com.example.yumarketforowners.databinding.FragmentNoticeListBinding
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.extension.addItemDivider
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NoticeListFragment : BaseFragment<FragmentNoticeListBinding>(), NoticeListView {
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
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
        /* TODO: 2022-11-3 목 14:24, implement navigation */
        showToast(message = noticeId.toString())
    }

    override fun loading(isLoading: Boolean) {
        /* TODO: 2022-11-3 목 13:43, implement loading */
    }

    override fun onError(throwable: Throwable) {
        /* TODO: 2022-11-3 목 13:43, implement error handling */
        throwable.message?.let { showToast(message = it) }
    }
}