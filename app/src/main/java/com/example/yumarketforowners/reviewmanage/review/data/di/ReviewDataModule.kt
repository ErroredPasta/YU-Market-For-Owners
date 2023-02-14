package com.example.yumarketforowners.reviewmanage.review.data.di

import com.example.yumarketforowners.reviewmanage.review.data.datasource.FirebaseReviewRemoteDataSource
import com.example.yumarketforowners.reviewmanage.review.data.datasource.ReviewRemoteDataSource
import com.example.yumarketforowners.reviewmanage.review.data.repository.ReviewRepositoryImpl
import com.example.yumarketforowners.reviewmanage.review.domain.repository.ReviewRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ReviewDataModule {

    @Binds
    fun bindReviewRemoteDataSource(dataSource: FirebaseReviewRemoteDataSource): ReviewRemoteDataSource

    @Binds
    fun bindReviewRepository(repository: ReviewRepositoryImpl): ReviewRepository
}