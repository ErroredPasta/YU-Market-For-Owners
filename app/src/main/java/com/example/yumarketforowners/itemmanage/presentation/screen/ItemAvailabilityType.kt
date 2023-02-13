package com.example.yumarketforowners.itemmanage.presentation.screen

enum class ItemAvailabilityType(
    val available: Boolean,
    val tabString: String
) {
    // TODO: 2022.05.30 replace hard coded strings to string resources
    AVAILABLE(true, "판매중"),
    UNAVAILABLE(false, "판매중지"),
}