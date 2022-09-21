package com.example.yumarketforowners.domain.model.orderlist

enum class OrderState(
    val stateString: String
) {
    PENDING("대기중"),
    ACCEPTED("접수"),
    DONE("완료"),
}