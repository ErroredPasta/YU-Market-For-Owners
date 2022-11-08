package com.example.yumarketforowners.domain.usecase.user

import com.example.yumarketforowners.domain.repository.user.UserRepository

class GetCurrentUserUseCase(
    private val repository: UserRepository
) {
    operator fun invoke() = repository.currentUser
}
