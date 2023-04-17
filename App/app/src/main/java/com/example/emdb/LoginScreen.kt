package com.example.emdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginScreen : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth
    private lateinit var signInBtn:Button
    private lateinit var registerTv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        supportActionBar?.hide();

        auth = FirebaseAuth.getInstance();

        val signInBtn = findViewById<Button>(R.id.signInBtn)
        signInBtn.setOnClickListener {
            val email = findViewById<EditText>(R.id.mailLoginTxt).text.toString();
            val password = findViewById<EditText>(R.id.pswdLoginTxt).text.toString();
            this.login(email,password);
        }

        val facebookBtn = findViewById<Button>(R.id.facebookBtn);
        val googleBtn = findViewById<Button>(R.id.googleBtn);

        val registerTv = findViewById<TextView>(R.id.registerTv)
        registerTv.setOnClickListener{
            this.goToRegister();
        }
    }

    private fun login(email:String, password: String){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener{task ->
            if(task.isSuccessful){

                Toast.makeText(applicationContext, "Lograste logearte", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java);
                startActivity(intent);
                finish();
            }
        }.addOnFailureListener{exception ->
            Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    private fun goToRegister(){
        val intent = Intent(this, RegisterScreen::class.java)
        startActivity(intent);
    }
}