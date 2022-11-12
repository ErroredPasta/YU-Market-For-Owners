package com.example.yumarketforowners.di.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LoginRepositoryQualifier(val type: LoginRepositoryType)

enum class LoginRepositoryType {
    DEFAULT, KAKAO, GOOGLE
}
