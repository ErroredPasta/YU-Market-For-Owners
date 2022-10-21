package com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket

import android.widget.ArrayAdapter
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.example.yumarketforowners.databinding.ActivityUpdateMarketBinding
import com.example.yumarketforowners.domain.model.market.MarketType
import com.example.yumarketforowners.domain.model.market.UpdateMarket
import com.example.yumarketforowners.presentation.screen.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UpdateMarketActivity : BaseActivity<ActivityUpdateMarketBinding>(), UpdateMarketListener,
    UpdateMarketView {
    override val binding: ActivityUpdateMarketBinding by lazy {
        ActivityUpdateMarketBinding.inflate(layoutInflater)
    }

    companion object {
        const val KEY_MARKET_ID = "MARKET_ID"
    }

    private val marketId by lazy {
        checkNotNull(intent.extras?.get(KEY_MARKET_ID)) {
            "marketId가 null입니다."
        } as Long
    }

    @Inject
    lateinit var presenter: EditMarketPresenter

    private var representativeImage: String? = null
    private var detailImage: String? = null

    private val representativeImageContract =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                representativeImage = uri.toString()
                binding.updateMarketRepresentativeImage.setImageURI(uri)
            } ?: showToast("Representative image select canceled")
        }

    private val detailImageContract =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                detailImage = it.toString()
                binding.updateMarketDetailImage.setImageURI(it)
            } ?: showToast("Detail image select canceled")
        }

    private val spinnerAdapter by lazy {
        ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            MarketType.values().map { it.typeString }
        )
    }

    override fun initState() {
        super.initState()

        binding.apply {
            updateMarketAddressEditText.keyListener = null
            listener = this@UpdateMarketActivity
            updateMarketTypeSpinner.adapter = spinnerAdapter
        }

        presenter.requestMarketDetail(marketId = marketId)
    }

    override fun onConfirmButtonClicked() = with(binding) {
        presenter.updateMarket(
            UpdateMarket(
                id = updateMarketUiState!!.id,
                name = updateMarketNameEditText.text.toString().trim(),
                marketType = MarketType.values()[updateMarketTypeSpinner.selectedItemPosition],
                marketRepresentativeImage = representativeImage
                    ?: updateMarketUiState!!.marketRepresentativeImage,
                marketDetailImage = detailImage,
                address = updateMarketAddressEditText.toString().trim(),
                detailAddress = updateMarketDetailAddressEditText.toString().trim()
            )
        )
    }

    override fun onCancelButtonClicked() {
        presenter.cancelEditMarket()
    }

    override fun loading(isLoading: Boolean) {
        /* TODO: 2022-10-19 수 22:00, implement loading */
    }

    override fun onRequestMarketDetailSuccess(market: UpdateMarket) {
        binding.updateMarketUiState = market
    }

    override fun onError(throwable: Throwable) {
        /* TODO: 2022-10-19 수 22:01, implement error */
        throwable.message?.let { showToast(message = it) }
    }

    override fun navigateBack() {
        finish()
    }

    override fun onRepresentativeImageClicked() {
        representativeImageContract.launch(
            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
        )
    }

    override fun onDetailImageClicked() {
        detailImageContract.launch(
            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
        )
    }

    override fun onAddressEditTextClicked() {
        /* TODO: 2022-10-20 목 00:12, navigate to address search screen */
        // expected
        // - latitude : 37.553686
        // - longitude : 126.925571
        binding.updateMarketAddressEditText.setText("서울시 마포구 와우산로29가길 69")
    }
}

interface UpdateMarketListener {
    fun onConfirmButtonClicked()
    fun onCancelButtonClicked()
    fun onAddressEditTextClicked()
    fun onRepresentativeImageClicked()
    fun onDetailImageClicked()
}