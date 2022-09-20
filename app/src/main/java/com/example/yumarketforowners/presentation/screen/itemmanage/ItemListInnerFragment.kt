package com.example.yumarketforowners.presentation.screen.itemmanage

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.yumarketforowners.databinding.InnerFragmentItemListBinding
import com.example.yumarketforowners.domain.model.itemmanage.Item
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.extension.addItemDivider
import com.example.yumarketforowners.presentation.recyclerview.listener.itemmanage.ItemManageViewHolderListener
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemListInnerFragment :
    BaseFragment<InnerFragmentItemListBinding>() {
    companion object {
        private const val AVAILABILITY_KEY = "AVAILABILITY_KEY"

        fun newInstance(available: Boolean) = ItemListInnerFragment().apply {
            arguments = bundleOf(AVAILABILITY_KEY to available)
        }
    }

    @Inject
    lateinit var presenter: ItemManagePresenter

    private val adapter by lazy {
        ModelRecyclerAdapter<Item>(
            object : ItemManageViewHolderListener {
                override fun onEditItemButtonClick(item: Item) {
                    // TODO: 2022.06.08 implement start edit item activity
                    Toast.makeText(context, "$item edit button clicked", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    private val available by lazy {
        requireArguments()[AVAILABILITY_KEY] as Boolean
    }

    private var items = listOf<Item>()
        set(value) {
            field = value.filter { it.available == available }
            adapter.submitList(field)
        }

    override fun initState() = with(binding) {
        itemListRecyclerView.run {
            this.adapter = this@ItemListInnerFragment.adapter
            addItemDivider(LinearLayout.VERTICAL)
        }

        requestData()
    }

    fun requestData() {
        presenter.requestData(0)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = InnerFragmentItemListBinding.inflate(inflater, container, false)

    fun loading(show: Boolean) {
        // TODO: 2022.07.10 implement loading
    }

    fun onRequestDataSuccess(items: List<Item>) {
        this.items = items
    }

    fun onRequestDataError(errorMessage: Int) {
        Toast.makeText(context, getText(errorMessage), Toast.LENGTH_SHORT).show()
    }
}