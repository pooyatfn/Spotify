package com.example.potify

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.potify.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //private val viewModel by viewModels<HomeViewModel>()

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding!!.root)

        val navController = findNavController(R.id.myNavHostFragment)
        //NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
        binding!!.bottomNavigationView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
}
