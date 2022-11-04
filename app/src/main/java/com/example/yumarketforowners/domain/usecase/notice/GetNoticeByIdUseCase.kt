package com.example.yumarketforowners.domain.usecase.notice

import com.example.yumarketforowners.domain.repository.notice.NoticeRepository

class GetNoticeByIdUseCase(
    private val repository: NoticeRepository
) {
    suspend operator fun invoke(noticeId: Long) = repository.getNoticeById(noticeId = noticeId)
}
