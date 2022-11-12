package com.example.yumarketforowners.domain.usecase.auth

import com.example.yumarketforowners.domain.repository.auth.LoginRepository

class KakaoLoginUseCase(
    private val repository: LoginRepository
) {

    suspend operator fun invoke(id: Long) = repository.login(id = id.toString(), password = "")
}
