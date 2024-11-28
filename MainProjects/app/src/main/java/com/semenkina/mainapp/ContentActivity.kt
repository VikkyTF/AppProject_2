package com.semenkina.mainapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//пустой экран, пока не трогаем
class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        val but_exit = findViewById<Button>(R.id.button_exit)
        val storage = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val save_entry = storage.getBoolean("save_entry", false)
        val intent_slash = Intent(this, SplashActivity::class.java)
        but_exit.setOnClickListener()
        {
            storage.edit().remove("save_entry").apply()
            startActivity(intent_slash)
        }
    }
}