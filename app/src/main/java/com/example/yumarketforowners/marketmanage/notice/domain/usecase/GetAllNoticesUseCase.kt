package com.example.yumarketforowners.marketmanage.notice.domain.usecase

import com.example.yumarketforowners.marketmanage.notice.domain.repository.NoticeRepository

class GetAllNoticesUseCase(
    private val repository: NoticeRepository
) {
    suspend operator fun invoke() = repository.getAllNotices().sortedByDescending { it.writtenAt }
}
