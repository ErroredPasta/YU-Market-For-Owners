package com.example.yumarketforowners.data.remote.datasource.auth

import com.example.yumarketforowners.di.singleton.Dispatcher
import com.example.yumarketforowners.di.singleton.DispatcherType
import com.example.yumarketforowners.domain.usecase.auth.UserNotFoundException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirebaseLoginRemoteDataSource @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    @Dispatcher(DispatcherType.IO) private val ioDispatcher: CoroutineDispatcher
) : LoginRemoteDataSource {

    override suspend fun login(
        id: String,
        password: String
    ): String = withContext(ioDispatcher) {
        val authResult = try {
            firebaseAuth
                .signInWithEmailAndPassword(id, password)
                .await()
                ?: throw UserNotFoundException()
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            throw UserNotFoundException()
        }

        return@withContext authResult.user!!.uid
    }

    override suspend fun logout() {
        TODO("Not yet implemented")
    }
}