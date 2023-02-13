package com.example.yumarketforowners.marketmanage.notice.data.repository

import com.example.yumarketforowners.marketmanage.notice.data.mapper.toNotice
import com.example.yumarketforowners.marketmanage.notice.data.datasource.NoticeRemoteDataSource
import com.example.yumarketforowners.marketmanage.notice.domain.model.Notice
import com.example.yumarketforowners.marketmanage.notice.domain.repository.NoticeRepository
import javax.inject.Inject

class NoticeRepositoryImpl @Inject constructor(
    private val remoteDataSource: NoticeRemoteDataSource
) : NoticeRepository {

    override suspend fun getAllNotices(): List<Notice> =
        remoteDataSource.getAllNotices().map { it.toNotice() }

    override suspend fun getNoticeById(noticeId: Long): Notice =
        remoteDataSource.getNoticeById(noticeId = noticeId).toNotice()
}