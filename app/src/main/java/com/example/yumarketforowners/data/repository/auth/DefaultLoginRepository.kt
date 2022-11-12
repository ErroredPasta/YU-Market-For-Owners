package com.example.yumarketforowners.data.repository.auth

import com.example.yumarketforowners.data.remote.datasource.auth.LoginRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.user.UserRemoteDataSource
import com.example.yumarketforowners.domain.repository.auth.LoginRepository
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