package com.example.yumarketforowners.domain.model.market

/* TODO: 2022-10-21 금 23:10, declare proper types */
enum class MarketType(val typeString: String) {
    FOOD_BEVERAGE("식/음료"),
    MART("편의점/마트"),
    SERVICE("서비스업종"),
    FASHION("패션의류"),
    ACCESSORY("패션잡화"),
    ETC("그외/마켓");
}