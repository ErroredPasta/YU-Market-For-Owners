package com.example.yumarketforowners.auth.domain.usecase

import com.example.yumarketforowners.auth.domain.model.User
import com.example.yumarketforowners.auth.domain.repository.UserRepository
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(updatedUser: User) =
        repository.updateUser(updatedUser = updatedUser)
}