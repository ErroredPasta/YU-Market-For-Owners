package com.example.yumarketforowners.orderlist.domain.model

enum class OrderState(
    val stateString: String
) {
    PENDING("대기중"),
    ACCEPTED("접수"),
    DONE("완료"),
    REJECTED("취소"),
}