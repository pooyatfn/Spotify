package com.example.potify

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.potify.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        var dialog: AlertDialog? = null
        viewModel.observeNetworkLost(this)
        viewModel.networkState.observe(this) { networkState ->
            if (networkState != null) {
                when (networkState) {
                    NetworkState.CONNECTED -> dialog?.cancel()
                    NetworkState.DISCONNECTED -> dialog = createDialog(this).also {
                        it.show()
                    }
                }
            }
        }

        val navController = findNavController(R.id.myNavHostFragment)
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    private fun createDialog(main: MainActivity): AlertDialog {
        val builder1: AlertDialog.Builder = AlertDialog.Builder(main).setMessage(
            "Your internet is not connected!\n" + "Please connect it or exit."
        ).setCancelable(false).setNegativeButton(
            "Exit"
        ) { dialog, _ ->
            finish()
            dialog.cancel()
        }

        return builder1.create()
    }
}
