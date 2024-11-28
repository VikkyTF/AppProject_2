package com.semenkina.mainapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val storage = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val save_phone = storage.getString("phone_number", "default")
        val save_email = storage.getString("phone_email", "default")
        val save_entry = storage.getBoolean("save_entry", false)
        val intent_log = Intent(this, LoginActivity::class.java)
        val intent_reg = Intent(this, RegistrationActivity::class.java)
        val intent_cont = Intent(this, ContentActivity::class.java)
        if (save_phone!="default" || save_email!="default")
        {
            if (save_entry==true)
            {
                startActivity(intent_cont)
            }
            else
            {
                startActivity(intent_log)
            }
        }
        else
        {
            startActivity(intent_reg)
        }
    }
}