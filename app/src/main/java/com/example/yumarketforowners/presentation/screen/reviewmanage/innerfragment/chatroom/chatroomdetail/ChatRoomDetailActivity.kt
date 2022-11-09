package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.chatroomdetail

import com.example.yumarketforowners.databinding.ActivityChatRoomDetailBinding
import com.example.yumarketforowners.domain.model.chatroom.Chat
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.screen.base.BaseActivity
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime
import javax.inject.Inject

@AndroidEntryPoint
class ChatRoomDetailActivity : BaseActivity<ActivityChatRoomDetailBinding>(), ChatRoomDetailView,
    ChatRoomDetailListener {
    override val binding: ActivityChatRoomDetailBinding by lazy {
        ActivityChatRoomDetailBinding.inflate(layoutInflater)
    }

    companion object {
        const val KEY_CHAT_R0OM_ID = "CHAT_R0OM_ID"
    }

    private val chatRoomId by lazy {
        @Suppress("DEPRECATION")
        checkNotNull(intent.extras?.get(KEY_CHAT_R0OM_ID)) {
            "chatRoomId가 null입니다."
        } as Long
    }

    @Inject
    lateinit var presenter: ChatRoomDetailPresenter

    private val adapter = ModelRecyclerAdapter<BaseViewHolderState>()

    override fun initState() {
        super.initState()
        binding.chatRoomDetailRecyclerView.adapter = adapter
        binding.chatRoomDetailSendButton.setOnClickListener { onSendButtonClicked() }
        presenter.requestChats(chatRoomId = chatRoomId)
    }

    override fun onRequestChatsSuccess(chats: List<ChatUiState>) {
        adapter.submitList(chats)
    }

    override fun afterSendingMessage() {
        binding.chatRoomDetailMessageEditText.setText("")
    }

    override fun loading(isLoading: Boolean) {
        /* TODO: 2022-11-9 수 03:51, implement loading */
    }

    override fun onError(throwable: Throwable) {
        /* TODO: 2022-11-9 수 03:51, implement error handling */
        throwable.message?.let { showToast(message = it) }
    }

    override fun onSendButtonClicked() {
        presenter.sendChat(
            chatRoomId = chatRoomId,
            chat = Chat(
                id = 0L,
                senderId = 0L, /* TODO: 2022-11-9 수 05:23, pass proper user id */
                message = binding.chatRoomDetailMessageEditText.text.toString().trim(),
                sentAt = LocalDateTime.now()
            )
        )
    }
}

interface ChatRoomDetailListener {
    fun onSendButtonClicked()
}