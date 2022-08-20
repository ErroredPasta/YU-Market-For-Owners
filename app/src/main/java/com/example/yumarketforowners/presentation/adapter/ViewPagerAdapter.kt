package com.example.yumarketforowners.presentation.adapter

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.yumarketforowners.presentation.screen.base.BaseFragment

class ViewPagerAdapter(
    fragment: BaseFragment<*>,
    private val fragmentList: List<BaseFragment<*>>,
) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = fragmentList.size
    override fun createFragment(position: Int) = fragmentList[position]
}