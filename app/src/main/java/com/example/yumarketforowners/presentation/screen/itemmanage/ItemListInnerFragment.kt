package com.example.yumarketforowners.presentation.screen.itemmanage

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.yumarketforowners.R
import com.example.yumarketforowners.databinding.InnerFragmentItemListBinding
import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.extension.addItemDivider
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.UpdateItemActivity
import com.example.yumarketforowners.presentation.viewholder.itemmanage.ItemUiState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemListInnerFragment :
    BaseFragment<InnerFragmentItemListBinding>(), ItemManageView {
    companion object {
        private const val AVAILABILITY_KEY = "AVAILABILITY_KEY"

        fun newInstance(available: Boolean) = ItemListInnerFragment().apply {
            arguments = bundleOf(AVAILABILITY_KEY to available)
        }
    }

    @Inject
    lateinit var presenter: ItemManagePresenter

    @Inject
    lateinit var navController: NavController

    private val adapter by lazy { ModelRecyclerAdapter<ItemUiState>() }

    private val available by lazy {
        @Suppress("DEPRECATION")
        requireArguments()[AVAILABILITY_KEY] as Boolean
    }

    override fun initState() = with(binding) {
        itemListRecyclerView.apply {
            this.adapter = this@ItemListInnerFragment.adapter
            addItemDivider(LinearLayout.VERTICAL)
        }

        requestData()
    }

    private fun requestData() {
        presenter.requestData(
            marketId = "cc898844-8f2f-451e-bccf-2e84cb195c46",
            available = available
        )
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = InnerFragmentItemListBinding.inflate(inflater, container, false)

    override fun loading(isLoading: Boolean) {
        // TODO: 2022.07.10 implement loading
    }

    override fun onRequestDataSuccess(data: List<ItemUiState>) {
        adapter.submitList(data)
    }

    override fun navigateToEditScreen(item: Item) {
        navController.navigate(
            R.id.action_itemManageFragment_to_updateItemActivity,
            bundleOf(UpdateItemActivity.KEY_ITEM_ID to item.id)
        )
    }

    override fun onError(throwable: Throwable) {
        /* TODO: 2022-10-22 토 21:30, implement error handling */
        throwable.message?.let { showToast(message = it) }
    }
}