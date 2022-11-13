package com.example.yumarketforowners.data.remote.datasource.review

import com.example.yumarketforowners.data.remote.dto.review.ReviewDto
import com.example.yumarketforowners.di.singleton.Dispatcher
import com.example.yumarketforowners.di.singleton.DispatcherType
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirebaseReviewRemoteDataSource @Inject constructor(
    private val database: FirebaseDatabase,
    @Dispatcher(DispatcherType.IO) private val ioDispatcher: CoroutineDispatcher
) : ReviewRemoteDataSource {

    override suspend fun getAllReviewsByMarketId(marketId: String): List<ReviewDto> = withContext(ioDispatcher) {
        val reference = database.getReference("/reviews/${marketId}")

        return@withContext reference.get().await().getValue<List<ReviewDto>>() ?: emptyList()
    }
}