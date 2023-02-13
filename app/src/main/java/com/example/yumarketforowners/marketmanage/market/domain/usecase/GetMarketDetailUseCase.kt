package com.example.yumarketforowners.marketmanage.market.domain.usecase

import com.example.yumarketforowners.marketmanage.market.domain.repository.MarketRepository

class GetMarketDetailUseCase(
    private val repository: MarketRepository
) {
    suspend operator fun invoke(marketId: String) = repository.getMarketDetailById(marketId = marketId)
}
