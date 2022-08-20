package com.example.yumarketforowners.presentation.screen.orderlist

enum class OrderState(
    val tabString: String
) {
    // TODO: 2022.06.05 replace hardcoded string to string resources
    PENDING("대기중"),
    ACCEPTED("접수"),
    DONE("완료"),
}