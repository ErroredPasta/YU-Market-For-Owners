package com.example.yumarketforowners.marketmanage.profile.presentation.screen

import com.example.yumarketforowners.auth.domain.model.User
import com.example.yumarketforowners.auth.domain.usecase.GetCurrentUserUseCase
import com.example.yumarketforowners.auth.domain.usecase.UpdateUserUseCase
import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class UpdateProfilePresenter @Inject constructor(
    private val view: UpdateProfileView,
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    @LifeCycleScope(LifeCycleScopeType.ACTIVITY) scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

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
