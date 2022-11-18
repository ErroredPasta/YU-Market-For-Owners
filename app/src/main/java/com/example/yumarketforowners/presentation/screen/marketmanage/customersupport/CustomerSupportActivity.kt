package com.example.yumarketforowners.presentation.screen.marketmanage.customersupport

import com.example.yumarketforowners.databinding.ActivityCustomerSupportBinding
import com.example.yumarketforowners.presentation.screen.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerSupportActivity : BaseActivity<ActivityCustomerSupportBinding>() {
    override val binding: ActivityCustomerSupportBinding by lazy {
        ActivityCustomerSupportBinding.inflate(layoutInflater)
    }
}