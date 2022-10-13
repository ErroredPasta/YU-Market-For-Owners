package com.example.yumarketforowners.domain.model.order

enum class DeliveryType(
    val string: String
) {
    IN_STORE("매장 이용"),
    TAKE_OUT("방문 수령"),
    DELIVERY("배달")
}
