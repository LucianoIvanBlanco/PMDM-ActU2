package com.example.act_uni2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.act_uni2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityHomeBinding
    private val binding: ActivityHomeBinding get() = _binding

    lateinit var navController: NavController   // para el control del nav

    private var nameValue: String? = null
    private var categoryValue: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent

        if (intent != null && intent.hasExtra("nameValue") && intent.hasExtra("categoryValue")) {
            nameValue = intent.getStringExtra("nameValue")
            categoryValue = intent.getStringExtra("categoryValue")
            Log.d("CategoryTag", "El valor es : $nameValue $categoryValue")
        }
        setBottomNavigation()


    }

    private fun setBottomNavigation() {
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(binding.fcvBottomNavigation.id) as NavHostFragment
        navController = navHostFragment.findNavController()

        if (navHostFragment != null) {
            binding.bnvHome.setupWithNavController(navController)
        }

        if (categoryValue == "1") {
            binding.bnvHome.selectedItemId = R.id.generalNewsFragment
        }

        if (categoryValue == "2") {
            binding.bnvHome.selectedItemId = R.id.sportsNewsFragment
        }

        if (categoryValue == "3") {
            binding.bnvHome.selectedItemId = R.id.techNewsFragment
        }

    }
}