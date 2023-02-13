package com.example.yumarketforowners.itemmanage.data.mapper

import com.example.yumarketforowners.itemmanage.data.dto.OptionDto
import com.example.yumarketforowners.itemmanage.data.dto.OptionGroupDto
import com.example.yumarketforowners.itemmanage.domain.model.Option
import com.example.yumarketforowners.itemmanage.domain.model.OptionGroup

fun List<OptionGroup>.toOptionGroupDtos() = map {
    OptionGroupDto(
        id = it.id,
        name = it.name,
        options = it.options.toOptionDtos(),
        minSelect = it.selectRange.first,
        maxSelect = it.selectRange.last
    )
}

private fun List<Option>.toOptionDtos() = map {
    OptionDto(
        id = it.id,
        name = it.name,
        additionalPrice = it.additionalPrice
    )
}

fun List<OptionGroupDto>.toOptionGroups() = map {
    OptionGroup(
        id = it.id,
        name = it.name,
        options = it.options.toOptions(),
        selectRange = it.minSelect..it.maxSelect
    )
}

private fun List<OptionDto>.toOptions() = map {
    Option(
        id = it.id,
        name = it.name,
        additionalPrice = it.additionalPrice
    )
}
