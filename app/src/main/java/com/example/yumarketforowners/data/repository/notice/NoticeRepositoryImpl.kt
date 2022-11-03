package com.example.yumarketforowners.data.repository.notice

import com.example.yumarketforowners.data.mapper.notice.toNotice
import com.example.yumarketforowners.data.remote.datasource.notice.NoticeRemoteDataSource
import com.example.yumarketforowners.domain.model.notice.Notice
import com.example.yumarketforowners.domain.repository.notice.NoticeRepository
import javax.inject.Inject

class NoticeRepositoryImpl @Inject constructor(
    private val remoteDataSource: NoticeRemoteDataSource
) : NoticeRepository {

    override suspend fun getAllNotices(): List<Notice> =
        remoteDataSource.getAllNotices().map { it.toNotice() }
}