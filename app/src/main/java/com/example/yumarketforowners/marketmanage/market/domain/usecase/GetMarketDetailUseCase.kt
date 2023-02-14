package com.example.yumarketforowners.marketmanage.market.domain.usecase

import com.example.yumarketforowners.marketmanage.market.domain.repository.MarketRepository
import javax.inject.Inject

class GetMarketDetailUseCase @Inject constructor(
    private val repository: MarketRepository
) {
    suspend operator fun invoke(marketId: String) = repository.getMarketDetailById(marketId = marketId)
}
