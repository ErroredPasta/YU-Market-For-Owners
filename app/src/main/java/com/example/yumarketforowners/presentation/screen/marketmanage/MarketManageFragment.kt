package com.example.yumarketforowners.presentation.screen.marketmanage

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.yumarketforowners.R
import com.example.yumarketforowners.databinding.FragmentMarketManageBinding
import com.example.yumarketforowners.domain.model.user.User
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
import com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket.UpdateMarketActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MarketManageFragment : BaseFragment<FragmentMarketManageBinding>(), MarketManageListener {

    @Inject
    lateinit var navController: NavController

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMarketManageBinding = FragmentMarketManageBinding.inflate(
        inflater, container, false
    )

    override fun initState() {
        binding.listener = this
        binding.userModel = User(
            userName = "user",
            marketName = "market",
            profileImage = "https://picsum.photos/200",
            id = 100L
        )
    }

    override fun onEditProfileClicked(user: User) {
        // TODO: 2022.06.10 start profile edit activity
        Toast.makeText(context, "$user edit clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onUpdateMarketClicked() {
        /* TODO: 2022-10-19 수 17:56, pass proper market id */
        navController.navigate(
            R.id.action_marketManageFragment_to_updateMarketActivity,
            bundleOf(UpdateMarketActivity.KEY_MARKET_ID to 1L)
        )
    }

    override fun onManageScheduleClicked() {
        // TODO: 2022.06.10 start schedule manage activity
        Toast.makeText(context, "manage schedule clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onManageReviewClicked() {
        // TODO: 2022.06.10 start review manage activity
        Toast.makeText(context, "manage review clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onNoticeClicked() {
        // TODO: 2022.06.10 start notice activity
        Toast.makeText(context, "notice clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onServiceCenterClicked() {
        // TODO: 2022.06.10 start service center activity
        Toast.makeText(context, "service center clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onSettingClicked() {
        // TODO: 2022.06.10 start setting activity
        Toast.makeText(context, "setting clicked", Toast.LENGTH_SHORT).show()
    }
}