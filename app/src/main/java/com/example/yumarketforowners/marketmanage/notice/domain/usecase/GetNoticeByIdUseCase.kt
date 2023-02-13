package com.example.yumarketforowners.marketmanage.notice.domain.usecase

import com.example.yumarketforowners.marketmanage.notice.domain.repository.NoticeRepository

class GetNoticeByIdUseCase(
    private val repository: NoticeRepository
) {
    suspend operator fun invoke(noticeId: Long) = repository.getNoticeById(noticeId = noticeId)
}
