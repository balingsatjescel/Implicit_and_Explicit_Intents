package com.example.implicitandexplicitintents

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.implicitandexplicitintents.SecondActivity


class MainActivity : AppCompatActivity() {
    lateinit var Name: EditText
    lateinit var Password: EditText
    lateinit var Login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Name = findViewById(R.id.etUsername)
        Password = findViewById(R.id.etPassword)
        Login = findViewById(R.id.btn_submit)

        Login.setOnClickListener(View.OnClickListener {
            if(Name.getText().toString() == "admin" && Password.getText().toString() == "admin") {
                Toast.makeText(applicationContext, "Login Successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Invalid Username & Password", Toast.LENGTH_SHORT).show()
            }
        })
    }
}