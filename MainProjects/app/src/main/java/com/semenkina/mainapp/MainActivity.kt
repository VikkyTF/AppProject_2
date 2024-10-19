package com.semenkina.mainapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val phone = findViewById<TextView>(R.id.number_textview)
        val email = findViewById<TextView>(R.id.email_textview)
        val edittext_number= findViewById<EditText>(R.id.editTextPhoneNumber)
        val edittext_email = findViewById<EditText>(R.id.editTextEmail)
        val edittext_password = findViewById<EditText>(R.id.editTextPassword)
        val edittext_COPYpassword = findViewById<EditText>(R.id.editTextRepeatPassword)
        var VARIATION = "phone"
        fun CLEAR()
        {
            edittext_email.setText("")
            edittext_number.setText("")
            edittext_password.setText("")
            edittext_COPYpassword.setText("")
        }
        phone.setOnClickListener()
        {
            phone.setTypeface(null,Typeface.BOLD)
            email.setTypeface(null,Typeface.NORMAL)
            phone.setTextColor(Color.parseColor("#602077"))
            email.setTextColor(Color.parseColor("#9980A8"))
            edittext_number.requestFocus()
            VARIATION = "phone"
            CLEAR()
        }
        email.setOnClickListener()
        {
            email.setTypeface(null,Typeface.BOLD)
            phone.setTypeface(null,Typeface.NORMAL)
            email.setTextColor(Color.parseColor("#602077"))
            phone.setTextColor(Color.parseColor("#9980A8"))
            edittext_email.requestFocus()
            VARIATION = "email"
            CLEAR()
        }
        button.setOnClickListener()
        {
            var password = edittext_password.text.toString()
            var COPYpassword = edittext_COPYpassword.text.toString()
            if(password == COPYpassword)
            {
                if (VARIATION == "phone")
                {
                    var num = edittext_number.text.toString()
                    if (num.indexOf("+") == 0 && num.length >= 8) {
                        Toast.makeText(this, "Успешный ввод", Toast.LENGTH_LONG).show()
                    }
                }
                else if (VARIATION == "email")
                {
                    var em = edittext_email.text.toString()
                    if (em.indexOf("@") != -1) {
                        Toast.makeText(this, "Успешный ввод", Toast.LENGTH_LONG).show()
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