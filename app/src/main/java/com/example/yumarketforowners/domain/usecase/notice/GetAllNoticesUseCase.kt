package com.example.yumarketforowners.domain.usecase.notice

import com.example.yumarketforowners.domain.repository.notice.NoticeRepository

class GetAllNoticesUseCase(
    private val repository: NoticeRepository
) {
    suspend operator fun invoke() = repository.getAllNotices().sortedByDescending { it.writtenAt }
}
