package com.example.yumarketforowners.marketmanage.market.presentation.screen.updatemarket

import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import com.example.yumarketforowners.databinding.ActivityUpdateMarketBinding
import com.example.yumarketforowners.marketmanage.market.domain.model.UpdateMarket
import com.example.yumarketforowners.core.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.core.presentation.base.BaseActivity
import com.example.yumarketforowners.marketmanage.market.presentation.screen.DayPickerDialog
import com.example.yumarketforowners.marketmanage.market.presentation.screen.TimePickerDialog
import com.example.yumarketforowners.marketmanage.market.presentation.viewholder.DeliveryFeeUiState
import dagger.hilt.android.AndroidEntryPoint
import java.time.DayOfWeek
import java.time.LocalTime
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
        @Suppress("DEPRECATION")
        checkNotNull(intent.extras?.get(KEY_MARKET_ID)) {
            "marketId가 null입니다."
        } as String
    }

    private val openTimePicker by lazy {
        TimePickerDialog(
            context = this,
            layoutInflater = layoutInflater,
            onPositiveButtonClicked = { openTimePicked(it) }
        )
    }

    private val closedTimePicker by lazy {
        TimePickerDialog(
            context = this,
            layoutInflater = layoutInflater,
            onPositiveButtonClicked = { closedTimePicked(it) }
        )
    }

    private val closedDaysPicker by lazy {
        DayPickerDialog(
            context = this,
            preCheckedDaysOfWeek = binding.updateMarketUiState!!.closedDays,
            onPositiveButtonClicked = { closedDaysPicked(it) }
        )
    }

    @Inject
    lateinit var presenter: UpdateMarketPresenter

    private var representativeImage: String? = null
    private var detailImage: String? = null

    private val adapter = ModelRecyclerAdapter<DeliveryFeeUiState>()

    private val representativeImageContract =
        registerForActivityResult(PickVisualMedia()) { uri ->
            uri?.let {
                representativeImage = it.path
                binding.updateMarketRepresentativeImage.setImageURI(it)
            } ?: showToast("Representative image select canceled")
        }

    private val detailImageContract =
        registerForActivityResult(PickVisualMedia()) { uri ->
            uri?.let {
                detailImage = it.path
                binding.updateMarketDetailImage.setImageURI(it)
            } ?: showToast("Detail image select canceled")
        }

    override fun initState() {
        super.initState()

        binding.apply {
            listener = this@UpdateMarketActivity
            updateMarketDeliveryFeeRecyclerView.adapter = adapter
        }
        presenter.requestMarketDetail(marketId = marketId)
    }

    override fun onConfirmButtonClicked() = with(binding) {
        val uiState = updateMarketUiState!!

        presenter.updateMarket(
            UpdateMarket(
                id = uiState.id,
                name = updateMarketNameEditText.text.toString().trim(),
                marketRepresentativeImage = representativeImage
                    ?: uiState.marketRepresentativeImage,
                marketDetailImage = detailImage,
                deliveryFees = emptyList(),
                openTimeRange = uiState.openTimeRange,
                closedDays = uiState.closedDays,
                phoneNumber = updateMarketPhoneNumberEditText.text.toString(),
            )
        )
    }

    override fun onCancelButtonClicked() {
        presenter.cancelUpdateMarket()
    }

    override fun loading(isLoading: Boolean) {
        /* TODO: 2022-10-19 수 22:00, implement loading */
    }

    override fun onRequestMarketDetailSuccess(market: UpdateMarket) {
        binding.updateMarketUiState = market
    }

    override fun showDeliveryFees(deliveryFees: List<DeliveryFeeUiState>) {
        adapter.submitList(deliveryFees)
    }

    override fun onError(throwable: Throwable) {
        /* TODO: 2022-10-19 수 22:01, implement error handling */
        throwable.message?.let { showToast(message = it) }
    }

    override fun navigateBack() {
        finish()
    }

    override fun onRepresentativeImageClicked() {
        representativeImageContract.launch(
            PickVisualMediaRequest(PickVisualMedia.ImageOnly)
        )
    }

    override fun onDetailImageClicked() {
        detailImageContract.launch(
            PickVisualMediaRequest(PickVisualMedia.ImageOnly)
        )
    }

    override fun onOpenTimeClicked() {
        openTimePicker.show()
    }

    override fun onClosedTimeClicked() {
        closedTimePicker.show()
    }

    override fun onClosedDayClicked() {
        closedDaysPicker.show()
    }

    private fun openTimePicked(openTime: LocalTime) = with(binding) {
        val uiState = updateMarketUiState!!

        updateMarketUiState = uiState.copy(
            openTimeRange = openTime..uiState.openTimeRange.endInclusive
        )
    }

    private fun closedTimePicked(closedTime: LocalTime) = with(binding) {
        val uiState = updateMarketUiState!!

        updateMarketUiState = uiState.copy(
            openTimeRange = uiState.openTimeRange.start..closedTime
        )
    }

    private fun closedDaysPicked(closedDays: List<DayOfWeek>) = with(binding) {
        updateMarketUiState = updateMarketUiState!!.copy(
            closedDays = closedDays
        )
    }

    override fun onAddDeliveryFeeButtonClicked() {
        presenter.addDeliveryFee()
    }
}

interface UpdateMarketListener {
    fun onConfirmButtonClicked()
    fun onCancelButtonClicked()
    fun onRepresentativeImageClicked()
    fun onDetailImageClicked()
    fun onOpenTimeClicked()
    fun onClosedTimeClicked()
    fun onClosedDayClicked()
    fun onAddDeliveryFeeButtonClicked()
}