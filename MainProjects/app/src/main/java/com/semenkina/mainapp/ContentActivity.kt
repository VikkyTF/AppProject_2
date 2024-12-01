package com.semenkina.mainapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContentActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        //////
        val but_exit = findViewById<Button>(R.id.button_exit)
        val storage = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val save_entry = storage.getBoolean("save_entry", false)
        val intent_slash = Intent(this, SplashActivity::class.java)
        but_exit.setOnClickListener()
        {
            storage.edit().remove("save_entry").apply()
            startActivity(intent_slash)
        }
        ///////
        navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        val bottom_nav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottom_nav.setupWithNavController(navController)
    }
}