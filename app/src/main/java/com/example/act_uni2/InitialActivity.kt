package com.example.act_uni2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import com.example.act_uni2.databinding.ActivityInitialBinding
import com.example.act_uni2.fragment.WelcomeFragment

class InitialActivity : AppCompatActivity() {


    private lateinit var binding: ActivityInitialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setWelcomeFragment()

    }

    private fun setWelcomeFragment() {
        val welcomeFragment: WelcomeFragment = WelcomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fcv_nav_graph, welcomeFragment)
        transaction.setTransition(TRANSIT_FRAGMENT_FADE)
        transaction.commit()

    }
}