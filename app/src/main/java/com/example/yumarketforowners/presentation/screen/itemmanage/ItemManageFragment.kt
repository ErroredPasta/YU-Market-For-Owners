package com.example.yumarketforowners.presentation.screen.itemmanage

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.yumarketforowners.databinding.FragmentItemManageBinding
import com.example.yumarketforowners.presentation.screen.base.BaseViewPagerFragment

class ItemManageFragment :
    BaseViewPagerFragment<FragmentItemManageBinding, ItemListInnerFragment>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentItemManageBinding = FragmentItemManageBinding.inflate(
        inflater, container, false
    )

    override val tabStrings = ItemAvailabilityType.values().map {
        it.tabString
    }

    override fun initState() {
        initViewPagerAndTabLayout(
            binding.itemManageViewPager,
            binding.itemManageTabLayout,
            ItemAvailabilityType.values().map {
                ItemListInnerFragment.newInstance(it.available)
            }
        )
    }
}