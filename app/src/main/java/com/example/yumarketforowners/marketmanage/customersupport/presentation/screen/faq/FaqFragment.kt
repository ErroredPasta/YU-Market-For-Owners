package com.example.yumarketforowners.marketmanage.customersupport.presentation.screen.faq

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.yumarketforowners.R
import com.example.yumarketforowners.databinding.FragmentFaqBinding
import com.example.yumarketforowners.marketmanage.customersupport.domain.model.FaqCategory
import com.example.yumarketforowners.core.presentation.base.BaseViewPagerFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FaqFragment : BaseViewPagerFragment<FragmentFaqBinding, FaqListFragment>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentFaqBinding.inflate(inflater, container, false)

    private val navController by lazy { findNavController() }

    override val tabStrings by lazy {
        FaqCategory.values().map { it.categoryName.toString() }
    }

    override fun initState() {
        super.initState()

        setClickListeners()

        initViewPagerAndTabLayout(
            viewPager = binding.faqViewPager,
            tabLayout = binding.faqTabLayout,
            innerFragments = FaqCategory.values().map { FaqListFragment.newInstance(faqCategory = it) }
        )
    }

    private fun setClickListeners() = with(binding) {
        faqEditButton.setOnClickListener { navController.navigate(R.id.action_faqFragment_to_emailFragment) }
        faqBack.setOnClickListener { navController.navigateUp() }
    }

    private val FaqCategory.categoryName
        get() = when (this) {
            FaqCategory.LOGIN -> getText(R.string.login)
            FaqCategory.USE -> getText(R.string.use_inquiry)
            FaqCategory.ORDER -> getText(R.string.order)
            FaqCategory.REVIEW -> getText(R.string.review)
            FaqCategory.ETC -> getText(R.string.etc)
        }
}