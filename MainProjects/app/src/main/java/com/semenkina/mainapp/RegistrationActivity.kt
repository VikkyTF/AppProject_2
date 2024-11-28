package com.semenkina.mainapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val button = findViewById<Button>(R.id.button)
        val phone = findViewById<TextView>(R.id.number_textview)
        val email = findViewById<TextView>(R.id.email_textview)
        val edittext_number_email= findViewById<EditText>(R.id.editTextPhoneNumber_Email)
        val edittext_password = findViewById<EditText>(R.id.editTextPassword)
        val edittext_COPYpassword = findViewById<EditText>(R.id.editTextRepeatPassword)
        var VARIATION = "phone"
        val APP_PREFERENCES = "settings"
        val storage = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        //public static final String APP_PREFERENCES_NAME = "Nickname"; // имя кота
        //public static final String APP_PREFERENCES_AGE = "Age";
        fun CLEAR()
        {
            edittext_number_email.setText("")
            edittext_password.setText("")
            edittext_COPYpassword.setText("")
        }
        phone.setOnClickListener()
        {
            phone.setTypeface(null,Typeface.BOLD)
            email.setTypeface(null,Typeface.NORMAL)
            phone.setTextColor(Color.parseColor("#602077"))
            email.setTextColor(Color.parseColor("#9980A8"))
            edittext_number_email.requestFocus()
            VARIATION = "phone"
            edittext_number_email.setHint("Введите номер телефона")
            CLEAR()
        }
        email.setOnClickListener()
        {
            email.setTypeface(null,Typeface.BOLD)
            phone.setTypeface(null,Typeface.NORMAL)
            email.setTextColor(Color.parseColor("#602077"))
            phone.setTextColor(Color.parseColor("#9980A8"))
            VARIATION = "email"
            edittext_number_email.setHint("Введите адрес почты")
            CLEAR()
        }
        button.setOnClickListener()
        {
            var password = edittext_password.text.toString()
            var COPYpassword = edittext_COPYpassword.text.toString()
            if(password == COPYpassword)
            {
                var num = edittext_number_email.text.toString()
                if (VARIATION == "phone")
                {
                    if ((num.indexOf("+") == 0 && num.length ==12) || (num.indexOf("8") == 0 && num.length ==11)){
                        Toast.makeText(this, "Успешный ввод", Toast.LENGTH_LONG).show()
                        storage.edit().putString("phone_number", num).apply()
                        storage.edit().putString("password", password).apply()
                        val intent_splash = Intent(this, SplashActivity::class.java)
                        //startActivity(intent_splash)
                    }
                }
                else if (VARIATION == "email")
                {
                    if (num.indexOf("@") != -1) {
                        Toast.makeText(this, "Успешный ввод", Toast.LENGTH_LONG).show()
                        storage.edit().putString("email", num).apply()
                        storage.edit().putString("password", password).apply()
                        val intent_splash = Intent(this, SplashActivity::class.java)
                        startActivity(intent_splash)
                    }
                }
                else
                {
                    Toast.makeText(this, "Неверный ввод данных, попробуйте снова", Toast.LENGTH_LONG).show()
                    CLEAR()
                }
            }
            else
            {
                Toast.makeText(this, "Неверный ввод данных, попробуйте снова", Toast.LENGTH_LONG).show()
                CLEAR()
            }
        }
    }
}