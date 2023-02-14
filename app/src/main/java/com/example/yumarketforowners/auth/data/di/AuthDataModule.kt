package com.example.yumarketforowners.auth.data.di

import com.example.yumarketforowners.auth.data.datasource.FakeUserRemoteDataSource
import com.example.yumarketforowners.auth.data.datasource.FirebaseLoginRemoteDataSource
import com.example.yumarketforowners.auth.data.datasource.LoginRemoteDataSource
import com.example.yumarketforowners.auth.data.datasource.UserRemoteDataSource
import com.example.yumarketforowners.auth.data.repository.DefaultLoginRepository
import com.example.yumarketforowners.auth.data.repository.GoogleLoginRepository
import com.example.yumarketforowners.auth.data.repository.KakaoLoginRepository
import com.example.yumarketforowners.auth.data.repository.UserRepositoryImpl
import com.example.yumarketforowners.auth.domain.di.LoginType
import com.example.yumarketforowners.auth.domain.di.LoginType.Type.*
import com.example.yumarketforowners.auth.domain.repository.LoginRepository
import com.example.yumarketforowners.auth.domain.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AuthDataModule {

    @Binds
    @Singleton
    fun bindUserRemoteDataSource(dataSource: FakeUserRemoteDataSource): UserRemoteDataSource

    @Binds
    fun bindLoginRemoteDataSource(authManager: FirebaseLoginRemoteDataSource): LoginRemoteDataSource

    @Binds
    fun bindUserRepository(repository: UserRepositoryImpl): UserRepository

    @Binds
    @LoginType(DEFAULT)
    fun bindDefaultLoginRepository(repository: DefaultLoginRepository): LoginRepository

    @Binds
    @LoginType(KAKAO)
    fun bindKakaoLoginRepository(repository: KakaoLoginRepository): LoginRepository

    @Binds
    @LoginType(GOOGLE)
    fun bindGoogleLoginRepository(repository: GoogleLoginRepository): LoginRepository

    companion object {
        @Provides
        @Singleton
        fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth
    }
}


