package com.example.smartphones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.smartphones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = binding.bottomNavigationView
        setupWithNavController(bottomNavigationView, navController)

        navController.addOnDestinationChangedListener{_, destination, _ ->
            bottomNavigationView.isVisible = destination.id != R.id.detailFragment
        }

    }
}