package com.example.yumarketforowners.itemmanage.presentation.screen.additem

import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import com.example.yumarketforowners.databinding.ActivityAddItemBinding
import com.example.yumarketforowners.core.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.core.presentation.base.BaseActivity
import com.example.yumarketforowners.itemmanage.presentation.viewholder.OptionGroupUiState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddItemActivity : BaseActivity<ActivityAddItemBinding>(), AddItemView,
    AddItemListener {

    override val binding: ActivityAddItemBinding by lazy {
        ActivityAddItemBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var presenter: AddItemPresenter
    private val adapter = ModelRecyclerAdapter<OptionGroupUiState>()

    private var itemImage: String? = null
    private val itemImageContract =
        registerForActivityResult(PickVisualMedia()) { uri ->
            uri?.let {
                itemImage = it.path
            } ?: showToast(message = "Item image select canceled")
        }

    override fun initState() {
        super.initState()
        binding.addItemOptionGroupRecyclerView.adapter = adapter
        setClickListeners()
    }

    private fun setClickListeners() = with(binding) {
        addItemRepresentativeImageView.setOnClickListener { onItemImageViewClicked() }
        addItemAddOptionGroupButton.setOnClickListener { onAddOptionGroupButtonClicked() }
        addItemConfirmButton.setOnClickListener { onConfirmButtonClicked() }
        addItemCancelButton.setOnClickListener { onCancelButtonClicked() }
    }

    override fun loading(isLoading: Boolean) {
        /* TODO: 2022-10-27 목 04:23, implement loading */
    }

    override fun onError(throwable: Throwable) {
        /* TODO: 2022-10-27 목 04:08, implement error handling */
        throwable.message?.let { showToast(message = it) }
    }

    override fun onConfirmButtonClicked() = with(binding) {
        presenter.addItem(
            itemToAdd = AddItemUiState(
                name = addItemNameEditText.text.toString().trim(),
                description = addItemDescriptionEditText.text.toString().trim(),
                stock = addItemStockEditText.text.toString().toInt(),
                price = addItemOriginalPriceEditText.text.toString().toInt(),
                discountedPrice = addItemDiscountedPriceEditText.text.toString().toInt(),
                imageUrl = itemImage,
                available = addItemAvailableCheckBox.isChecked
            )
        )
    }

    override fun onCancelButtonClicked() {
        presenter.cancelUpdateItem()
    }

    override fun navigateBack() {
        finish()
    }

    override fun onAddOptionGroupButtonClicked() {
        presenter.addOptionGroup()
    }

    override fun showOptionGroups(optionGroups: List<OptionGroupUiState>) {
        adapter.submitList(optionGroups)
    }

    override fun onItemImageViewClicked() {
        itemImageContract.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
    }
}

interface AddItemListener {
    fun onConfirmButtonClicked()
    fun onCancelButtonClicked()
    fun onAddOptionGroupButtonClicked()
    fun onItemImageViewClicked()
}