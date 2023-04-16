package com.example.emdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.TextView

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        supportActionBar?.hide();

        val registerTv = findViewById<TextView>(R.id.registerTv);
        registerTv.setOnClickListener{
            this.goToRegister();
        }

    }

    private fun goToRegister(){
        val intent = Intent(this, RegisterScreen::class.java)
        startActivity(intent);
    }
}