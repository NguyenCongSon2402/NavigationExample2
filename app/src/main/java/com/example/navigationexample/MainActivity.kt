package com.example.navigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationexample.databinding.ActivityMainBinding
import com.example.navigationexample.ui.HomeViewModel
import com.example.navigationexample.ui.base.BaseActivity
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import java.security.AccessController

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(getBinding = ActivityMainBinding::inflate) {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val homeViewModel: HomeViewModel by viewModels()

    override fun initObserve() {
        TODO("Not yet implemented")
    }

    override fun initViews() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNav = binding.bottomNav
        bottomNav.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.searchFragment)
        )
        // cho phep xuất hien title va nup up tren actionBar
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun getData() {
        super.getData()
    }

    // cho phep nhan up
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}