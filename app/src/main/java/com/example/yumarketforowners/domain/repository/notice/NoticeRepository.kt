package com.example.yumarketforowners.domain.repository.notice

import com.example.yumarketforowners.domain.model.notice.Notice

interface NoticeRepository {
    suspend fun getAllNotices(): List<Notice>
    suspend fun getNoticeById(noticeId: Long): Notice
}
