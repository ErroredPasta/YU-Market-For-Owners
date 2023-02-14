package com.example.yumarketforowners.auth.domain.usecase

import com.example.yumarketforowners.auth.domain.di.LoginType
import com.example.yumarketforowners.auth.domain.di.LoginType.Type.KAKAO
import com.example.yumarketforowners.auth.domain.repository.LoginRepository
import javax.inject.Inject

class KakaoLoginUseCase @Inject constructor(
    @LoginType(KAKAO) private val repository: LoginRepository
) {

    suspend operator fun invoke(id: Long) = repository.login(id = id.toString(), password = "")
}
