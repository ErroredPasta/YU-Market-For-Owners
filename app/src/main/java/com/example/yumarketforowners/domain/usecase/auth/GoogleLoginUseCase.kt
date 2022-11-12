package com.example.yumarketforowners.domain.usecase.auth

import com.example.yumarketforowners.domain.repository.auth.LoginRepository

class GoogleLoginUseCase(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(id: String) = repository.login(id = id, password = "")
}
