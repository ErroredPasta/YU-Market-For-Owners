package com.example.yumarketforowners.auth.data.repository

import com.example.yumarketforowners.auth.data.datasource.LoginRemoteDataSource
import com.example.yumarketforowners.auth.data.datasource.UserRemoteDataSource
import com.example.yumarketforowners.auth.domain.repository.LoginRepository
import javax.inject.Inject

class DefaultLoginRepository @Inject constructor(
    private val loginRemoteDataSource: LoginRemoteDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) : LoginRepository {

    override suspend fun login(id: String, password: String) {
        val userId = loginRemoteDataSource.login(id = id, password = password)
        userRemoteDataSource.getUserById(userId = userId)
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }
}