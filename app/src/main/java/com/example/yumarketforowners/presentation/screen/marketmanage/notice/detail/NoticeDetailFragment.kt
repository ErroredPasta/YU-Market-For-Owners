package com.example.yumarketforowners.presentation.screen.marketmanage.notice.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.yumarketforowners.databinding.FragmentNoticeDetailBinding
import com.example.yumarketforowners.domain.model.notice.Notice
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NoticeDetailFragment : BaseFragment<FragmentNoticeDetailBinding>(), NoticeDetailView {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentNoticeDetailBinding.inflate(inflater, container, false)

    private val navArgs by navArgs<NoticeDetailFragmentArgs>()

    @Inject
    lateinit var presenter: NoticeDetailPresenter

    override fun initState() {
        super.initState()
        presenter.requestNoticeById(noticeId = navArgs.noticeId)
    }

    override fun loading(isLoading: Boolean) {
        /* TODO: 2022-11-4 금 18:52, implement loading */
    }

    override fun onError(throwable: Throwable) {
        /* TODO: 2022-11-4 금 18:52, implement error handling */
        throwable.message?.let { showToast(message = it) }
    }

    override fun onRequestNoticeSuccess(notice: Notice) {
        binding.noticeDetailUiState = notice
    }
}