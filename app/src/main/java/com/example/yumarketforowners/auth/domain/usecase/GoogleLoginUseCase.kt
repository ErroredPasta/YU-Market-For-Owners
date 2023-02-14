package com.example.yumarketforowners.auth.domain.usecase

import com.example.yumarketforowners.auth.domain.di.LoginType
import com.example.yumarketforowners.auth.domain.di.LoginType.Type.GOOGLE
import com.example.yumarketforowners.auth.domain.repository.LoginRepository
import javax.inject.Inject

class GoogleLoginUseCase @Inject constructor(
    @LoginType(GOOGLE) private val repository: LoginRepository
) {
    suspend operator fun invoke(id: String) = repository.login(id = id, password = "")
}
