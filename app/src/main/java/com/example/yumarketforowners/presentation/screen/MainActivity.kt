package com.example.yumarketforowners.presentation.screen

import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.example.yumarketforowners.databinding.ActivityMainBinding
import com.example.yumarketforowners.presentation.screen.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var navControllerProvider: Provider<NavController>

    private val navController by lazy { navControllerProvider.get() }

    override fun initState() = with(binding) {
        bottomNavigationView.setupWithNavController(navController)
    }
}