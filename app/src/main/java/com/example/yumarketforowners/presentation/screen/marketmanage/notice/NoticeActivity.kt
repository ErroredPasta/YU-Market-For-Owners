package com.example.yumarketforowners.presentation.screen.marketmanage.notice

import com.example.yumarketforowners.databinding.ActivityNoticeBinding
import com.example.yumarketforowners.presentation.screen.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoticeActivity : BaseActivity<ActivityNoticeBinding>() {

    override val binding: ActivityNoticeBinding by lazy {
        ActivityNoticeBinding.inflate(layoutInflater)
    }
}