package com.example.yumarketforowners.presentation.screen.marketmanage.customersupport

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.yumarketforowners.databinding.FragmentEmailBinding
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmailFragment : BaseFragment<FragmentEmailBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentEmailBinding.inflate(inflater, container, false)

    private val navController by lazy { findNavController() }

    override fun initState() {
        super.initState()
        setClickListeners()
    }

    private fun setClickListeners() = with(binding) {
        emailSend.setOnClickListener { onSendButtonClicked() }
        emailBack.setOnClickListener { navigateBack() }
    }

    private fun onSendButtonClicked() {
        val title = binding.titleEdit.text.toString()
        val content = binding.contentEdit.text.toString()

        runCatching {
            validateEmail(title = title, content = content)
        }.onSuccess {
            navigateToSendEmailScreen(title = title, content = content)
            navController.navigateUp()
        }.onFailure {
            it.message?.let { message -> showToast(message = message) }
        }
    }

    private fun validateEmail(title: String, content: String) {
        check(title.isNotEmpty()) { "제목을 입력해 주세요." }
        check(content.isNotEmpty()) { "제목을 입력해 주세요." }
    }

    private fun navigateToSendEmailScreen(title: String, content: String) {
        startActivity(
            Intent.createChooser(
                createEmailIntent(title = title, content = content), "Send Email"
            )
        )
    }

    private fun createEmailIntent(
        title: String,
        content: String
    ) = Intent(Intent.ACTION_SENDTO).apply {
        type = "text/plain"
        data = Uri.parse("mailto:")

        putExtra(Intent.EXTRA_EMAIL, arrayOf(INQUIRY_EMAIL))
        putExtra(Intent.EXTRA_SUBJECT, title)
        putExtra(Intent.EXTRA_TEXT, content)
    }

    private fun navigateBack() {
        navController.navigateUp()
    }

    companion object {
        private const val INQUIRY_EMAIL = "gege2848@naver.com"
    }
}