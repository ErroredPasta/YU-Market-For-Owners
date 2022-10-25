package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.chatroomdetail

import com.example.yumarketforowners.databinding.ActivityChatRoomDetailBinding
import com.example.yumarketforowners.presentation.screen.base.BaseActivity

class ChatRoomDetailActivity : BaseActivity<ActivityChatRoomDetailBinding>() {
    override val binding: ActivityChatRoomDetailBinding by lazy {
        ActivityChatRoomDetailBinding.inflate(layoutInflater)
    }

    companion object {
        const val KEY_CHAT_R0OM_ID = "CHAT_R0OM_ID"
    }

    private val chatRoomId by lazy {
        checkNotNull(intent.extras?.get(KEY_CHAT_R0OM_ID)) {
            "chatRoomId가 null입니다."
        } as Long
    }

    override fun initState() {
        super.initState()
        binding.textView2.text = "chat room id : $chatRoomId"
    }
}