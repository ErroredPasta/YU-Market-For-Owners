package com.example.yumarketforowners.auth.domain.usecase

import com.example.yumarketforowners.auth.domain.repository.UserRepository

class GetCurrentUserUseCase(
    private val repository: UserRepository
) {
    operator fun invoke() = repository.currentUser
}
