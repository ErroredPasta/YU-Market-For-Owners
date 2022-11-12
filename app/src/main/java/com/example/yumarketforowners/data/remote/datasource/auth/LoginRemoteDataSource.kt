package com.example.yumarketforowners.data.remote.datasource.auth

interface LoginRemoteDataSource {
    suspend fun login(id: String, password: String): String
    suspend fun logout()
}