package com.example.yumarketforowners.domain.usecase.market

import com.example.yumarketforowners.domain.model.market.UpdateMarket
import com.example.yumarketforowners.domain.repository.market.MarketRepository

class UpdateMarketUseCase(
    private val repository: MarketRepository
) {
    suspend operator fun invoke(marketToUpdate: UpdateMarket) {
        validateUpdateInfo(marketToUpdate)
        repository.updateMarket(marketToUpdate)
    }

    private fun validateUpdateInfo(marketToUpdate: UpdateMarket) {
        if (
            marketToUpdate.name.isEmpty() ||
            marketToUpdate.address.isEmpty() ||
            marketToUpdate.marketRepresentativeImage.isEmpty()
        ) {
            throw IllegalArgumentException("필요한 정보들을 모두 입력하세요.")
        }
    }
}
