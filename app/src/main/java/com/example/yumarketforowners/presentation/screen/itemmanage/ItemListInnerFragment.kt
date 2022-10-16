package com.example.yumarketforowners.presentation.screen.itemmanage

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.yumarketforowners.databinding.InnerFragmentItemListBinding
import com.example.yumarketforowners.domain.model.item.Item
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.extension.addItemDivider
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
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

    private val adapter by lazy { ModelRecyclerAdapter<ItemUiState>() }

    private val available by lazy {
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
        presenter.requestData(marketId = 0L, available = available)
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

    override fun onRequestDataError(errorMessage: Int) {
        Toast.makeText(context, getText(errorMessage), Toast.LENGTH_SHORT).show()
    }

    override fun navigateToEditScreen(item: Item) {
        Toast.makeText(context, "Edit item's id : ${item.id}", Toast.LENGTH_SHORT).show()
    }
}