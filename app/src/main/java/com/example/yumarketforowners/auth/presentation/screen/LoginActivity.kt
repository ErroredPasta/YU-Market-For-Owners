package com.example.yumarketforowners.auth.presentation.screen

import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import com.example.yumarketforowners.R
import com.example.yumarketforowners.databinding.ActivityLoginBinding
import com.example.yumarketforowners.MainActivity
import com.example.yumarketforowners.core.presentation.base.BaseActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(), LoginView, LoginListener {

    override val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var presenter: LoginPresenter

    @Inject
    lateinit var kakaoApiClient: UserApiClient

    @Inject
    lateinit var googleSignInClient: GoogleSignInClient

    private val googleSignInContract =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val loginTask: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(result.data)

                onGoogleSignIn(loginTask = loginTask)
            }
        }

    private val kakaoLoginCallback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null && token != null) {
            kakaoApiClient.me { user, _ ->
                val kakaoId = user!!.id!!
                presenter.onKakaoLoginSuccess(kakaoId = kakaoId)
            }
        } else {
            alertLoginFailure()
        }
    }

    override fun initState() {
        super.initState()
        setClickListeners()
    }

    private fun setClickListeners() = with(binding) {
        login.setOnClickListener { onLoginButtonClicked() }
        kakao.setOnClickListener { onKakaoButtonClicked() }
        google.setOnClickListener { onGoogleButtonClicked() }
        sign.setOnClickListener { onSignUpClicked() }
        find.setOnClickListener { onFindPasswordClicked() }
    }

    override fun navigateToMainScreen() {
        startActivity(
            Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK or
                        Intent.FLAG_ACTIVITY_NEW_TASK
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
        googleSignInContract.launch(googleSignInClient.signInIntent)
    }

    override fun onKakaoButtonClicked() = with(kakaoApiClient) {
        if (isKakaoTalkLoginAvailable(this@LoginActivity)) {
            loginWithKakaoTalk(this@LoginActivity, callback = kakaoLoginCallback)
        } else {
            loginWithKakaoAccount(this@LoginActivity, callback = kakaoLoginCallback)
        }
    }

    override fun onSignUpClicked() {
        TODO("Not yet implemented")
    }

    override fun onFindPasswordClicked() {
        TODO("Not yet implemented")
    }

    private fun onGoogleSignIn(loginTask: Task<GoogleSignInAccount>) {
        val account = try {
            loginTask.getResult(ApiException::class.java) ?: kotlin.run {
                alertLoginFailure()
                return
            }
        } catch (e: ApiException) {
            alertLoginFailure()
            return
        }

        presenter.onGoogleLoginSuccess(googleId = account.id!!)
    }
}

interface LoginListener {
    fun onLoginButtonClicked()
    fun onGoogleButtonClicked()
    fun onKakaoButtonClicked()
    fun onSignUpClicked()
    fun onFindPasswordClicked()
}