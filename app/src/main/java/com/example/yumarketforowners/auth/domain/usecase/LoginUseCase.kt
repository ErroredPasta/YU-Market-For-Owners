package com.example.yumarketforowners.auth.domain.usecase

import com.example.yumarketforowners.auth.domain.di.LoginType
import com.example.yumarketforowners.auth.domain.di.LoginType.Type.DEFAULT
import com.example.yumarketforowners.auth.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    @LoginType(DEFAULT) private val userRepository: LoginRepository
) {

    suspend operator fun invoke(id: String, password: String) {
        validateIdAndPassword(id = id, password = password)
        userRepository.login(id = id, password = password)
    }

    private fun validateIdAndPassword(id: String, password: String) {
        check(id.isNotEmpty()) { "아이디를 입력해주세요." }
        check(password.isNotEmpty()) { "비밀번호를 입력해주세요." }
    }
}

class UserNotFoundException(message: String? = null) : Exception(message)
