package com.example.yumarketforowners.domain.validator

import com.example.yumarketforowners.domain.model.market.DeliveryFee

object DeliveryFeeValidator {

    fun validateDeliveryFees(deliveryFees: List<DeliveryFee>) {
        for (index in (1 until deliveryFees.size)) {
            with(deliveryFees[index]) {
                val previousDeliveryFee = deliveryFees[index - 1]

                check(priceRange.start == previousDeliveryFee.priceRange.last) {
                    "${index}번째 배달비 시작 금액이 이전 배달비 금액과 이어지지 않습니다."
                }

                check(fee < previousDeliveryFee.fee) { "${index}번째 배달비가 이전 배달비보다 비쌀 수 없습니다." }
            }
        }
    }
}