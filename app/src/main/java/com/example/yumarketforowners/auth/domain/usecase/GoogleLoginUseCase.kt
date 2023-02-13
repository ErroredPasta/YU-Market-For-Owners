package com.example.yumarketforowners.auth.domain.usecase

import com.example.yumarketforowners.auth.domain.repository.LoginRepository

class GoogleLoginUseCase(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(id: String) = repository.login(id = id, password = "")
}
