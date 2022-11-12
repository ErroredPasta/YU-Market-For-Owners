package com.example.yumarketforowners.di.singleton

import com.example.yumarketforowners.BuildConfig
import com.example.yumarketforowners.data.remote.api.MarketApi
import com.example.yumarketforowners.data.remote.api.TMapApi
import com.example.yumarketforowners.data.remote.api.TMapApiStub
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {
    @Binds
    @Singleton
    fun bindTMapApiInterface(api: TMapApiStub): TMapApi

    companion object {
        @Provides
        fun provideGsonConverterFactory() = GsonConverterFactory.create()

        @Provides
        fun provideOkHttpClient() = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                }
            ).build()

        @Provides
        @Singleton
        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            gsonConverterFactory: GsonConverterFactory
        ) = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .baseUrl("http://shop.withmarkets.net/")
            .build()

        @Provides
        @Singleton
        fun provideMarketApi(
            retrofit: Retrofit
        ) = retrofit.create(MarketApi::class.java)
    }
}