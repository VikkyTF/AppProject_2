package com.semenkina.mainapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val log_phone_email = findViewById<EditText>(R.id.LoginPhoneNumber_Email)
        val log_password = findViewById<EditText>(R.id.Login_Password)
        val save_check = findViewById<CheckBox>(R.id.save_login_check)
        val buttn_login= findViewById<Button>(R.id.Login_button)
        val buttn_reg = findViewById<Button>(R.id.Login_reg)
        val intent_reg = Intent(this, RegistrationActivity::class.java)
        val intent_cont = Intent(this, ContentActivity::class.java)
        val storage = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val save_phone = storage.getString("phone_number", "default")
        val save_email = storage.getString("email", "default")
        val save_password = storage.getString("password", "default")
        fun CLEAR()
        {
            log_phone_email.setText("")
            log_password.setText("")
        }
        buttn_reg.setOnClickListener()
        {
            startActivity(intent_reg)
        }
        buttn_login.setOnClickListener()
        {
            var password = log_password.text.toString()
            var ph_em = log_phone_email.text.toString()
            if ((ph_em==save_email)||(ph_em==save_phone))
            {
                if (password==save_password)
                {
                    if (save_check.isChecked)
                    {
                        storage.edit().putBoolean("save_entry", true).apply()
                    }
                    else
                    {
                        storage.edit().putBoolean("save_entry", false).apply()
                    }
                    Toast.makeText(this, "Успешный ввод", Toast.LENGTH_LONG).show()
                    startActivity(intent_cont)
                } else
                {
                    Toast.makeText(this, "Данные отсутствуют, попробуйте снова", Toast.LENGTH_LONG).show()
                    CLEAR()
                }
            }else
            {
                Toast.makeText(this, "Данные отсутствуют, попробуйте снова", Toast.LENGTH_LONG).show()
                CLEAR()
            }
        }
    }
}