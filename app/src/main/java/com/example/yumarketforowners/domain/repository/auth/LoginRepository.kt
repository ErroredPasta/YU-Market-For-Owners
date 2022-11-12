package com.example.yumarketforowners.domain.repository.auth

interface LoginRepository {
    suspend fun login(id: String, password: String)
    suspend fun logout()
}