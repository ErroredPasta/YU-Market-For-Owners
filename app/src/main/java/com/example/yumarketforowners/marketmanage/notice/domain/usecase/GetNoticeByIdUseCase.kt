package com.example.yumarketforowners.marketmanage.notice.domain.usecase

import com.example.yumarketforowners.marketmanage.notice.domain.repository.NoticeRepository
import javax.inject.Inject

class GetNoticeByIdUseCase @Inject constructor(
    private val repository: NoticeRepository
) {
    suspend operator fun invoke(noticeId: Long) = repository.getNoticeById(noticeId = noticeId)
}
