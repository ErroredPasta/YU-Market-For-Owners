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
            id = "1",
            userName = "user",
            profileImage = "https://picsum.photos/200",
            telephoneNumber = "010-0101-1010",
            businessRegistrationNumber = "121122121"
        )
    }

    override fun onEditProfileClicked(user: User) {
        /* TODO: 2022-11-8 화 05:42, pass proper user id */
        navController.navigate(R.id.action_marketManageFragment_to_updateProfileActivity)
    }

    override fun onUpdateMarketClicked() {
        /* TODO: 2022-10-19 수 17:56, pass proper market id */
        navController.navigate(
            R.id.action_marketManageFragment_to_updateMarketActivity,
            bundleOf(UpdateMarketActivity.KEY_MARKET_ID to "cc898844-8f2f-451e-bccf-2e84cb195c46")
        )
    }

    override fun onManageScheduleClicked() {
        // TODO: 2022.06.10 start schedule manage activity
        Toast.makeText(context, "manage schedule clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onManageReviewClicked() {
        navController.navigate(R.id.review_manage_menu)
    }

    override fun onNoticeClicked() {
        navController.navigate(R.id.action_marketManageFragment_to_noticeActivity)
    }

    override fun onCustomerSupportCenterClicked() {
        // TODO: 2022.06.10 start service center activity
        navController.navigate(R.id.action_marketManageFragment_to_customerSupportActivity)
    }

    override fun onSettingClicked() {
        // TODO: 2022.06.10 start setting activity
        Toast.makeText(context, "setting clicked", Toast.LENGTH_SHORT).show()
    }
}