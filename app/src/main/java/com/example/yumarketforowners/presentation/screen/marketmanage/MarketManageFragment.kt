package com.example.yumarketforowners.presentation.screen.marketmanage

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.example.yumarketforowners.domain.model.marketmanage.UserModel
import com.example.yumarketforowners.databinding.FragmentMarketManageBinding
import com.example.yumarketforowners.presentation.screen.base.BaseFragment

class MarketManageFragment : BaseFragment<FragmentMarketManageBinding>(), MarketManageListener {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMarketManageBinding = FragmentMarketManageBinding.inflate(
        inflater, container, false
    )

    override fun initState() {
        binding.listener = this
        binding.userModel = UserModel(
            name = "user",
            storeName = "store",
            imageUrl = "https://picsum.photos/200"
        )
    }

    override fun onEditProfileClicked(user: UserModel) {
        // TODO: 2022.06.10 start profile edit activity
        Toast.makeText(context, "$user edit clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onEditMarketClicked() {
        // TODO: 2022.06.10 start profile edit activity
        Toast.makeText(context, "edit market clicked", Toast.LENGTH_SHORT).show()
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