package com.example.yumarketforowners.presentation.screen.base

import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import com.example.yumarketforowners.presentation.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

abstract class BaseViewPagerFragment<VB : ViewBinding, IF : BaseFragment<*>> : BaseFragment<VB>() {

    private var _innerFragments: List<IF>? = null
    protected val innerFragments get() = _innerFragments!!

    protected abstract val tabStrings: List<String>

    private var _viewPagerAdapter: ViewPagerAdapter? = null
    protected val viewPagerAdapter get() = _viewPagerAdapter!!

    protected fun initViewPagerAndTabLayout(
        viewPager: ViewPager2,
        tabLayout: TabLayout,
        innerFragments: List<IF>
    ) {
        _viewPagerAdapter = ViewPagerAdapter(this, innerFragments)

        viewPager.run {
            this.adapter = this@BaseViewPagerFragment.viewPagerAdapter
            offscreenPageLimit = innerFragments.size
        }

        this._innerFragments = innerFragments

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabStrings[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _innerFragments = null
        _viewPagerAdapter = null
    }
}