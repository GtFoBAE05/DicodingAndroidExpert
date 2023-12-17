package com.example.androidexpert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.androidexpert.databinding.ActivityMainBinding
import org.koin.core.context.GlobalContext.loadKoinModules


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navView = binding.bottomNavigationView

        val navController = findNavController(R.id.fragmentContainerView)
        navView.setupWithNavController(navController)



    }
}