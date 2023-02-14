package com.example.yumarketforowners.marketmanage.notice.domain.usecase

import com.example.yumarketforowners.marketmanage.notice.domain.repository.NoticeRepository
import javax.inject.Inject

class GetAllNoticesUseCase @Inject constructor(
    private val repository: NoticeRepository
) {
    suspend operator fun invoke() = repository.getAllNotices().sortedByDescending { it.writtenAt }
}
