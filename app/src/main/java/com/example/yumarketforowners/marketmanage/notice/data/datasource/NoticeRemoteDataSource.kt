package com.example.yumarketforowners.marketmanage.notice.data.datasource

import com.example.yumarketforowners.marketmanage.notice.data.dto.NoticeDto

interface NoticeRemoteDataSource {
    suspend fun getAllNotices(): List<NoticeDto>
    suspend fun getNoticeById(noticeId: Long): NoticeDto
}
