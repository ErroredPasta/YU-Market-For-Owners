package com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import com.example.yumarketforowners.databinding.FragmentAddressSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddressSearchScreen : DialogFragment() {

    private var _binding: FragmentAddressSearchBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddressSearchBinding.inflate(inflater, container, false).apply {
            webView.settings.javaScriptEnabled = true
            webView.addJavascriptInterface(JavaScriptInterface(), JAVA_SCRIPT_INTERFACE_NAME)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private inner class JavaScriptInterface {
        @JavascriptInterface
        fun processDATA(address: String?) {
            navController.previousBackStackEntry?.savedStateHandle?.set("roadAddress", address)
            dismiss()
        }
    }

    companion object {
        private const val JAVA_SCRIPT_INTERFACE_NAME = "Android"
    }
}
