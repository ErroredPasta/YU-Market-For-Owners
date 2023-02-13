package com.example.yumarketforowners.reviewmanage

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.yumarketforowners.databinding.FragmentReviewManageBinding
import com.example.yumarketforowners.core.presentation.base.BaseFragment
import com.example.yumarketforowners.core.presentation.base.BaseViewPagerFragment

class ReviewManageFragment :
    BaseViewPagerFragment<FragmentReviewManageBinding, BaseFragment<*>>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentReviewManageBinding.inflate(inflater, container, false)


    override val tabStrings by lazy {
        BaseReviewInnerFragment.Type.values().map {
            it.tabString
        }
    }

    override fun initState() {
        initViewPagerAndTabLayout(
            binding.reviewManageViewPager,
            binding.reviewManageTabLayout,
            BaseReviewInnerFragment.Type.values().map {
                BaseReviewInnerFragment.newInstance(it) as BaseFragment<*>
            }
        )
    }
}