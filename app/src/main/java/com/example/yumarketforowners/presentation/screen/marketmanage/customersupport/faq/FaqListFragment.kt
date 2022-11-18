package com.example.yumarketforowners.presentation.screen.marketmanage.customersupport.faq

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.yumarketforowners.databinding.FragmentFaqListBinding
import com.example.yumarketforowners.domain.model.customersupport.Faq
import com.example.yumarketforowners.domain.model.customersupport.FaqCategory
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.mapper.customersupport.toFaqData
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
import com.example.yumarketforowners.presentation.viewholder.customersupport.FaqUiState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FaqListFragment : BaseFragment<FragmentFaqListBinding>(), FaqListView {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentFaqListBinding.inflate(inflater, container, false)

    companion object {
        private const val CS_CATEGORY_KEY = "CSCategoryKey"

        fun newInstance(faqCategory: FaqCategory) = FaqListFragment().apply {
            arguments = bundleOf(CS_CATEGORY_KEY to faqCategory)
        }
    }

    private val faqCategory by lazy {
        @Suppress("DEPRECATION")
        requireArguments().getSerializable(CS_CATEGORY_KEY) as FaqCategory
    }

    @Inject
    lateinit var presenter: FaqListPresenter

    private val navController by lazy { findNavController() }
    private val adapter by lazy { ModelRecyclerAdapter<FaqUiState>() }


    override fun initState() {
        super.initState()
        binding.faqListRecyclerView.adapter = adapter
        presenter.requestCustomerSupportList(faqCategory = faqCategory)
    }

    override fun onRequestFaqListSuccess(faqList: List<FaqUiState>) {
        adapter.submitList(faqList)
    }

    override fun navigateToDetailScreen(faq: Faq) {
        navController.navigate(
            FaqFragmentDirections.actionFaqFragmentToFaqDetailFragment(
                faqData = faq.toFaqData()
            )
        )
    }

    override fun loading(isLoading: Boolean) {
        /* TODO: 2022-11-12 토 01:32, implement loading */
    }

    override fun onError(throwable: Throwable) {
        /* TODO: 2022-11-12 토 01:32, implement loading */
        throwable.message?.let { showToast(message = it) }
    }
}