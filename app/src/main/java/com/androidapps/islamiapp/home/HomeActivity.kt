package com.androidapps.islamiapp.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.androidapps.islamiapp.R
import com.androidapps.islamiapp.databinding.ActivityHomeBinding
import com.androidapps.islamiapp.fragments.ahadeth.AhadethFragment
import com.androidapps.islamiapp.fragments.quran.QuranFragment
import com.androidapps.islamiapp.fragments.radio.RadioFragment
import com.androidapps.islamiapp.fragments.sebha.SebhaFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.idBottomNavigation.setOnItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.id_quran_icon_navigation_bar -> QuranFragment()
                R.id.id_ahadeth_icon_navigation_bar -> AhadethFragment()
                R.id.id_sebha_icon_navigation_bar -> SebhaFragment()
                R.id.id_radio_icon_navigation_bar -> RadioFragment()
                else -> QuranFragment()
            }
            showFragment(fragment)
            return@setOnItemSelectedListener true
        }
        binding.idBottomNavigation.selectedItemId = R.id.id_quran_icon_navigation_bar
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }
}