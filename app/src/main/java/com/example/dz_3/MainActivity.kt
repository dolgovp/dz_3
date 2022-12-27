package com.example.dz_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var fragment: Fragment = HomeFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
        val btnNav: BottomNavigationView = findViewById(R.id.btn_nav)
        btnNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home_nav -> {
                    fragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                R.id.favor_nav -> {
                    fragment = FavorFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                R.id.profile_nav -> {
                    fragment = ProfileFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
                    true
                }
                else->false
            }
        }
    }

}