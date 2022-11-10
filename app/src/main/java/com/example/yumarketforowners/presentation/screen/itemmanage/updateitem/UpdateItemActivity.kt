package com.example.yumarketforowners.presentation.screen.itemmanage.updateitem

import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.*
import com.example.yumarketforowners.databinding.ActivityUpdateItemBinding
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.screen.base.BaseActivity
import com.example.yumarketforowners.presentation.viewholder.itemmanage.OptionGroupUiState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UpdateItemActivity : BaseActivity<ActivityUpdateItemBinding>(), UpdateItemView,
    UpdateItemListener {

    override val binding: ActivityUpdateItemBinding by lazy {
        ActivityUpdateItemBinding.inflate(layoutInflater)
    }

    companion object {
        const val KEY_ITEM_ID = "ITEM_ID"
    }

    private val itemId by lazy {
        @Suppress("DEPRECATION")
        checkNotNull(intent.extras?.get(KEY_ITEM_ID)) {
            "itemId가 null입니다."
        } as Long
    }

    @Inject
    lateinit var presenter: UpdateItemPresenter
    private val adapter = ModelRecyclerAdapter<OptionGroupUiState>()

    private val itemImageContract =
        registerForActivityResult(PickVisualMedia()) { uri ->
            uri?.let {
                binding.updateItemUiState!!.imageUrl = it.path
                binding.updateItemRepresentativeImageView.setImageURI(it)
            } ?: showToast(message = "Item image select canceled")
        }

    override fun initState() {
        super.initState()

        binding.updateItemOptionGroupRecyclerView.adapter = adapter
        binding.listener = this
        presenter.requestItem(itemId = itemId)
    }

    override fun onRequestItemSuccess(item: UpdateItemUiState) {
        binding.updateItemUiState = item
    }

    override fun loading(isLoading: Boolean) {
        /* TODO: 2022-10-27 목 04:23, implement loading */
    }

    override fun onError(throwable: Throwable) {
        /* TODO: 2022-10-27 목 04:08, implement error handling */
        throwable.message?.let { showToast(message = it) }
    }

    override fun onConfirmButtonClicked() {
        presenter.updateItem(updateItemUiState = binding.updateItemUiState!!)
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

interface UpdateItemListener {
    fun onConfirmButtonClicked()
    fun onCancelButtonClicked()
    fun onAddOptionGroupButtonClicked()
    fun onItemImageViewClicked()
}