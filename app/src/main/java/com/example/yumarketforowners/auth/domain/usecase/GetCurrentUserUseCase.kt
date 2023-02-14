package com.example.yumarketforowners.auth.domain.usecase

import com.example.yumarketforowners.auth.domain.repository.UserRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke() = repository.currentUser
}
