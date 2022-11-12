package com.example.yumarketforowners.domain.usecase.auth

import com.example.yumarketforowners.domain.repository.user.UserRepository

class LoginUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(id: String, password: String) {
        validateIdAndPassword(id = id, password = password)
        userRepository.login(id = id, password = password)
    }

    private fun validateIdAndPassword(id: String, password: String) {
        check(id.isNotEmpty()) { "아이디를 입력해주세요." }
        check(password.isNotEmpty()) { "아이디를 입력해주세요." }
    }
}

class UserNotFoundException(message: String? = null) : Exception(message)
