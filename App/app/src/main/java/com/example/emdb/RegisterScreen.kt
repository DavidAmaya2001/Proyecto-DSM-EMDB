package com.example.emdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class RegisterScreen : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private lateinit var signUpBtn:Button
    private lateinit var loginTv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)
        supportActionBar?.hide();

        auth = FirebaseAuth.getInstance();

        val signUpBtn = findViewById<Button>(R.id.signUpBtn);
        signUpBtn.setOnClickListener {
            val email = findViewById<EditText>(R.id.mailRegisterTxt).text.toString();
            val firstName = findViewById<EditText>(R.id.nameRegisterTxt).text.toString();
            val secondName = findViewById<EditText>(R.id.secNameRegisterTxt).text.toString();
            val password = findViewById<EditText>(R.id.pswdRegisterTxt).text.toString();
            val comPassword = findViewById<EditText>(R.id.pswdComRegisterTxt).text.toString();

            register(email,firstName,secondName,password,comPassword);
        }

        val loginTv = findViewById<TextView>(R.id.loginTv);
        loginTv.setOnClickListener{
            this.goToLogin();
        }
    }

    private fun register(email:String,firstName:String,secondName:String,password: String, comPassword: String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{task ->
            if(task.isSuccessful){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent);
                finish();
            }
        }
    }

    private fun goToLogin(){
        val intent = Intent(this, LoginScreen::class.java);
        startActivity(intent);
    }
}