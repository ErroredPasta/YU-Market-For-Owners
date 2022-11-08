package com.example.yumarketforowners.presentation.screen.marketmanage.profile

import com.example.yumarketforowners.domain.model.user.User
import com.example.yumarketforowners.domain.usecase.user.GetCurrentUserUseCase
import com.example.yumarketforowners.domain.usecase.user.UpdateUserUseCase
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Provider

class UpdateProfilePresenter(
    private val view: UpdateProfileView,
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(view, scopeProvider) {

    fun requestCurrentUser() {
        getCurrentUserUseCase().onStart {
            view.loading(isLoading = true)
        }.onEach {
            checkNotNull(it)
            view.onRequestUserSuccess(it)
        }.onCompletion {
            view.loading(isLoading = false)
        }.catch {
            view.onError(it)
        }.launchIn(coroutineScope)
    }

    fun cancelUpdateProfile() {
        view.navigateBack()
    }

    fun updateProfile(updatedUser: User) {
        coroutineScope.launch {
            updateUserUseCase(updatedUser = updatedUser)
            view.navigateBack()
        }
    }
}
