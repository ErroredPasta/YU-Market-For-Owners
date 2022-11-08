package com.example.yumarketforowners.presentation.screen.marketmanage.profile

import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import com.example.yumarketforowners.databinding.ActivityUpdateProfileBinding
import com.example.yumarketforowners.domain.model.user.User
import com.example.yumarketforowners.presentation.extension.text
import com.example.yumarketforowners.presentation.screen.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UpdateProfileActivity : BaseActivity<ActivityUpdateProfileBinding>(), UpdateProfileView,
    UpdateProfileListener {

    override val binding: ActivityUpdateProfileBinding by lazy {
        ActivityUpdateProfileBinding.inflate(layoutInflater)
    }

    private var profileImage: String? = null
    private val profileImageContract =
        registerForActivityResult(PickVisualMedia()) { uri ->
            uri?.let {
                profileImage = it.path
                binding.updateProfileImageView.setImageURI(it)
            } ?: showToast("Profile image select canceled")
        }

    @Inject
    lateinit var presenter: UpdateProfilePresenter

    override fun onRequestUserSuccess(user: User) {
        binding.userUiState = user.also {
            profileImage = it.profileImage
        }
    }

    override fun loading(isLoading: Boolean) {
        /* TODO: 2022-11-7 월 00:35, implement loading */
    }

    override fun onError(throwable: Throwable) {
        /* TODO: 2022-11-7 월 00:35, implement error handling */
        throwable.message?.let { showToast(message = it) }
    }

    override fun initState() {
        super.initState()
        binding.listener = this
        presenter.requestCurrentUser()
    }

    override fun onConfirmButtonClicked() = with(binding) {
        presenter.updateProfile(
            updatedUser = User(
                id = userUiState!!.id,
                telephoneNumber = userUiState!!.telephoneNumber,
                userName = updateProfileUserNameTextField.text.trim(),
                profileImage = profileImage,
                businessRegistrationNumber = userUiState!!.businessRegistrationNumber
            )
        )
    }

    override fun onCancelButtonClicked() {
        presenter.cancelUpdateProfile()
    }

    override fun onProfileImageClicked() {
        profileImageContract.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
    }

    override fun navigateBack() {
        finish()
    }
}

interface UpdateProfileListener {
    fun onConfirmButtonClicked()
    fun onCancelButtonClicked()
    fun onProfileImageClicked()
}