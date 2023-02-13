package com.example.yumarketforowners.marketmanage.customersupport.presentation.screen

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.yumarketforowners.R
import com.example.yumarketforowners.databinding.FragmentCustomerSupportBinding
import com.example.yumarketforowners.core.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerSupportFragment : BaseFragment<FragmentCustomerSupportBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCustomerSupportBinding.inflate(inflater, container, false)

    private val navController by lazy { findNavController() }

    private var hasCallPhonePermission: Boolean = false
    private val callPhonePermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
            hasCallPhonePermission = result
        }

    private val customerSupportCenterCallDialog by lazy {
        CallDialog(
            context = requireContext(),
            title = "YU Market",
            message = "000-1111-2222",
            onPositiveButtonClicked = { navigateToCallScreen(phoneNumber = "000-1111-2222") },
            onCancelButtonClicked = { showToast(message = "통화를 취소했습니다.") }
        )
    }

    private val foodSafetyCallDialog by lazy {
        CallDialog(
            context = requireContext(),
            title = "불량식품 신고",
            message = "1399",
            onPositiveButtonClicked = { navigateToCallScreen(phoneNumber = "1399") },
            onCancelButtonClicked = { showToast(message = "통화를 취소했습니다.") }
        )
    }

    override fun initState() {
        super.initState()
        setClickListeners()
    }

    private fun setClickListeners() = with(binding) {
        questionCenter.setOnClickListener { navController.navigate(R.id.action_customerSupportFragment_to_faqFragment) }
        centerNumber.setOnClickListener { customerSupportCenterCallDialog.show() }
        pollution.setOnClickListener { foodSafetyCallDialog.show() }
        emailCenter.setOnClickListener { navController.navigate(R.id.action_customerSupportFragment_to_emailFragment) }
        back.setOnClickListener { navigateBack() }
    }

    private fun navigateToCallScreen(phoneNumber: String) {
        if (hasCallPhonePermission) {
            startActivity(
                Intent(Intent.ACTION_CALL).apply {
                    data = Uri.parse("tel:$phoneNumber")
                }
            )
        } else {
            callPhonePermissionLauncher.launch(Manifest.permission.CALL_PHONE)
        }
    }

    private fun navigateBack() {
        requireActivity().finish()
    }
}
