package com.example.yumarketforowners.domain.usecase.market

import com.example.yumarketforowners.domain.repository.market.MarketRepository

class GetMarketDetailUseCase(
    private val repository: MarketRepository
) {
    suspend operator fun invoke(marketId: String) = repository.getMarketDetailById(marketId = marketId)
}
