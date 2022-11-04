package com.example.yumarketforowners.data.remote.datasource.notice

import com.example.yumarketforowners.data.remote.dto.notice.NoticeDto

interface NoticeRemoteDataSource {
    suspend fun getAllNotices(): List<NoticeDto>
    suspend fun getNoticeById(noticeId: Long): NoticeDto
}
