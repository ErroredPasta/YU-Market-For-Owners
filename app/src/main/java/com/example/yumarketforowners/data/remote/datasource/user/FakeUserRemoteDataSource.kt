package com.example.yumarketforowners.data.remote.datasource.user

import android.util.Log
import com.example.yumarketforowners.data.remote.dto.user.UserDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FakeUserRemoteDataSource"

@Singleton
class FakeUserRemoteDataSource @Inject constructor() : UserRemoteDataSource {

    private val userList = (1..10).map {
        createUserDto(it)
    }.toMutableList()

    private val _currentUser = MutableStateFlow(value = userList[0].copy())
    override val currentUser: Flow<UserDto?> = _currentUser.asStateFlow()

    override suspend fun getUserById(userId: String) {
        userList.find { it.id == userId }?.let {
            _currentUser.emit(it)
        }
    }

    override suspend fun updateUser(updatedUser: UserDto) {
        val index = userList.indexOfFirst { it.id == updatedUser.id }

        if (index != -1) {
            _currentUser.update { updatedUser }
            userList[index] = updatedUser
            Log.d(TAG, "updateUser: ${_currentUser.value}")
            Log.d(TAG, "updateUser: ${userList[index]}")
        } else {
            Log.d(TAG, "updateUser: no update")
        }
    }

    // region temporary helper functions ===========================================================

    private fun createUserDto(it: Int) = UserDto(
        id = it.toString(),
        telephoneNumber = "010-0101-1010",
        userName = "userName $it",
        profileImage = "https://picsum.photos/200",
        businessRegistrationNumber = "121122121"
    )

    // endregion temporary helper functions ========================================================
}