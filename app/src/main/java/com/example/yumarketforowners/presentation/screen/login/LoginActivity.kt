package com.example.yumarketforowners.presentation.screen.login

import android.content.Intent
import com.example.yumarketforowners.R
import com.example.yumarketforowners.databinding.ActivityLoginBinding
import com.example.yumarketforowners.presentation.screen.MainActivity
import com.example.yumarketforowners.presentation.screen.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(), LoginView, LoginListener {

    override val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var presenter: LoginPresenter

    override fun initState() {
        super.initState()
        setClickListeners()
    }

    private fun setClickListeners() = with(binding) {
        login.setOnClickListener { onLoginButtonClicked() }
    }

    override fun navigateToMainScreen() {
        startActivity(
            Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            }
        )
    }

    override fun alertLoginFailure() {
        showToast(message = getString(R.string.failed_to_login))
    }

    override fun loading(isLoading: Boolean) {
        /* TODO: 2022-11-12 토 16:37, implement loading */
    }

    override fun onError(throwable: Throwable) {
        /* TODO: 2022-11-12 토 16:36, implement error handling */
        throwable.message?.let { showToast(message = it) }
    }

    override fun onLoginButtonClicked() {
        presenter.login(
            id = binding.editId.text.toString(),
            password = binding.editPassword.text.toString()
        )
    }

    override fun onGoogleButtonClicked() {
        TODO("Not yet implemented")
    }

    override fun onKakaoButtonClicked() {
        TODO("Not yet implemented")
    }

    override fun onSignUpClicked() {
        TODO("Not yet implemented")
    }

    override fun onFindPasswordClicked() {
        TODO("Not yet implemented")
    }
}

interface LoginListener {
    fun onLoginButtonClicked()
    fun onGoogleButtonClicked()
    fun onKakaoButtonClicked()
    fun onSignUpClicked()
    fun onFindPasswordClicked()
}