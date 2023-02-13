package com.example.yumarketforowners.itemmanage.presentation.screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.yumarketforowners.R
import com.example.yumarketforowners.databinding.FragmentItemManageBinding
import com.example.yumarketforowners.core.presentation.base.BaseViewPagerFragment

class ItemManageFragment :
    BaseViewPagerFragment<FragmentItemManageBinding, ItemListInnerFragment>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentItemManageBinding = FragmentItemManageBinding.inflate(
        inflater, container, false
    )

    private val navController by lazy { findNavController() }

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

        binding.itemManageFragmentAddItemButton.setOnClickListener {
            navController.navigate(R.id.action_itemManageFragment_to_addItemActivity)
        }
    }
}