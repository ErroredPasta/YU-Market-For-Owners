package com.example.yumarketforowners.presentation.screen.itemmanage

import com.example.yumarketforowners.domain.repository.ItemManageRepository
import javax.inject.Inject

class  ItemManagePresenter @Inject constructor(
    private val view: ItemManageContract.View,
    private val itemManageRepository: ItemManageRepository
) : ItemManageContract.Presenter {

    override fun requestData(marketId: Long) {
        view.loading(show = true)
        // TODO: 2022.05.27 get item by market id
        val result = itemManageRepository.getItemsByMarketId(marketId)
        view.loading(show = false)

        if (result is ItemManageContract.State.Success) {
            view.onRequestDataSuccess(result.items)
        } else {
            view.onRequestDataError((result as ItemManageContract.State.Error).errorMessage)
        }
    }
}