package com.example.yumarketforowners.marketmanage.market.domain.usecase

import com.example.yumarketforowners.marketmanage.market.domain.model.UpdateMarket
import com.example.yumarketforowners.marketmanage.market.domain.repository.MarketRepository
import com.example.yumarketforowners.marketmanage.market.domain.validator.DeliveryFeeValidator

class UpdateMarketUseCase(
    private val repository: MarketRepository
) {
    suspend operator fun invoke(marketToUpdate: UpdateMarket) {
        validateUpdateInfo(marketToUpdate)
        repository.updateMarket(marketToUpdate)
    }

    private fun validateUpdateInfo(marketToUpdate: UpdateMarket) {
        check(marketToUpdate.name.isNotEmpty()) { "가게 이름을 입력해 주세요." }
        check(marketToUpdate.marketRepresentativeImage.isNotEmpty()) { "가게 대표 이미지를 선택해 주세요." }

        DeliveryFeeValidator.validateDeliveryFees(deliveryFees = marketToUpdate.deliveryFees)
    }
}
