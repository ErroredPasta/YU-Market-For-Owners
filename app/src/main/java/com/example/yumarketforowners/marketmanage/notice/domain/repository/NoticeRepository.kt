package com.example.yumarketforowners.marketmanage.notice.domain.repository

import com.example.yumarketforowners.marketmanage.notice.domain.model.Notice

interface NoticeRepository {
    suspend fun getAllNotices(): List<Notice>
    suspend fun getNoticeById(noticeId: Long): Notice
}
