package com.example.yumarketforowners.auth.domain.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LoginType(val type: Type) {

    enum class Type {
        DEFAULT, KAKAO, GOOGLE
    }
}

