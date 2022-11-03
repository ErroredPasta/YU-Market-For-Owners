package com.example.yumarketforowners.data.remote.datasource.notice

import com.example.yumarketforowners.data.remote.dto.notice.NoticeDto
import java.time.LocalDate
import javax.inject.Inject

class FakeNoticeRemoteDataSource @Inject constructor() : NoticeRemoteDataSource {

    private val noticeList = (1..10).map {
        NoticeDto(
            id = it.toLong(),
            title = "title $it",
            content = "content $it",
            writtenAt = LocalDate.now(),
        )
    }

    override suspend fun getAllNotices(): List<NoticeDto> = noticeList
}