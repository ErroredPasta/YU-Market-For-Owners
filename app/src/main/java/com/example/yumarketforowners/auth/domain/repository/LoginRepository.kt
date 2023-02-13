package com.example.yumarketforowners.auth.domain.repository

interface LoginRepository {
    suspend fun login(id: String, password: String)
    suspend fun logout()
}