package com.example.yumarketforowners.marketmanage.notice.presentation.screen

import com.example.yumarketforowners.databinding.ActivityNoticeBinding
import com.example.yumarketforowners.core.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoticeActivity : BaseActivity<ActivityNoticeBinding>() {

    override val binding: ActivityNoticeBinding by lazy {
        ActivityNoticeBinding.inflate(layoutInflater)
    }
}