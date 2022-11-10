package com.example.yumarketforowners.data.mapper.item

import com.example.yumarketforowners.data.remote.dto.item.OptionDto
import com.example.yumarketforowners.data.remote.dto.item.OptionGroupDto
import com.example.yumarketforowners.domain.model.item.Option
import com.example.yumarketforowners.domain.model.item.OptionGroup

fun List<OptionGroup>.toOptionGroupDtos() = map {
    OptionGroupDto(
        id = it.id,
        name = it.name,
        options = it.options.toOptionDtos(),
        selectRange = it.selectRange
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
        selectRange = it.selectRange
    )
}

private fun List<OptionDto>.toOptions() = map {
    Option(
        id = it.id,
        name = it.name,
        additionalPrice = it.additionalPrice
    )
}
