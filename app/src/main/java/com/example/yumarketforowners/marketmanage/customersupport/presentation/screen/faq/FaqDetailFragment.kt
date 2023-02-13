package com.example.yumarketforowners.marketmanage.customersupport.presentation.screen.faq

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.yumarketforowners.databinding.FragmentFaqDetailBinding
import com.example.yumarketforowners.core.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.parcelize.Parcelize

@AndroidEntryPoint
class FaqDetailFragment : BaseFragment<FragmentFaqDetailBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentFaqDetailBinding.inflate(inflater, container, false)

    private val navArgs by navArgs<FaqDetailFragmentArgs>()
    private val navController by lazy { findNavController() }

    override fun initState() {
        super.initState()

        initView(faqData = navArgs.faqData)
        binding.uturn.setOnClickListener { navigateBack() }
    }

    private fun initView(faqData: FaqData) = with(binding) {
        title.text = faqData.csTitle
        contentTitle.text = faqData.csContentTitle
        contentBody.text = faqData.csContentBody
    }

    private fun navigateBack() {
        navController.navigateUp()
    }
}

@Parcelize
data class FaqData(
    val csTitle: String,
    val csContentTitle: String,
    val csContentBody: String,
    val csAuthor: String,
) : Parcelable
