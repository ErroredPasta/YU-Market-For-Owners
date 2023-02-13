package com.example.yumarketforowners.auth.data.datasource

interface LoginRemoteDataSource {
    suspend fun login(id: String, password: String): String
    suspend fun logout()
}