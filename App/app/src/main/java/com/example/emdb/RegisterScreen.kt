package com.example.emdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegisterScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)
        supportActionBar?.hide();

        val loginTv = findViewById<TextView>(R.id.loginTv);
        loginTv.setOnClickListener{
            this.goToLogin();
        }
    }

    private fun goToLogin(){
        val intent = Intent(this, LoginScreen::class.java);
        startActivity(intent);
    }
}