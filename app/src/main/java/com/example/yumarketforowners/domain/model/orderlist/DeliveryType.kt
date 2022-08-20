package com.example.yumarketforowners.domain.model.orderlist

enum class DeliveryType(
    val string: String
) {
    // TODO: 2022.06.08 replace hard coded strings with string resources
    IN_STORE("매장 이용"),
    TAKE_OUT("방문 수령"),
    DELIVERY("배달")
}
