package com.example.yumarketforowners.marketmanage.customersupport.presentation.screen

import com.example.yumarketforowners.databinding.ActivityCustomerSupportBinding
import com.example.yumarketforowners.core.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerSupportActivity : BaseActivity<ActivityCustomerSupportBinding>() {
    override val binding: ActivityCustomerSupportBinding by lazy {
        ActivityCustomerSupportBinding.inflate(layoutInflater)
    }
}