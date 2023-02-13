package com.example.yumarketforowners.auth.domain.usecase

import com.example.yumarketforowners.auth.domain.repository.LoginRepository

class KakaoLoginUseCase(
    private val repository: LoginRepository
) {

    suspend operator fun invoke(id: Long) = repository.login(id = id.toString(), password = "")
}
