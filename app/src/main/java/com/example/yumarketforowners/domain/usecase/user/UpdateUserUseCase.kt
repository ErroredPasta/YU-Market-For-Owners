package com.example.yumarketforowners.domain.usecase.user

import com.example.yumarketforowners.domain.model.user.User
import com.example.yumarketforowners.domain.repository.user.UserRepository

class UpdateUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(updatedUser: User) =
        repository.updateUser(updatedUser = updatedUser)
}