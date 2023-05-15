package com.example.app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ContactEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_email)

        val btnSendEmail = findViewById<Button>(R.id.btnSendEmail)
        val txtrecipient = findViewById<EditText>(R.id.txtrecipient) // Se puede usar en caso de proporcionar correos distintos
        val txtsubject = findViewById<EditText>(R.id.txtsubject)
        val txtmessage = findViewById<EditText>(R.id.txtmessageSend)
        val btncancel = findViewById<Button>(R.id.btnReturn)

        btnSendEmail.setOnClickListener {
            val recipient = "emdbsoporte@gmail.com"
            val subject = txtsubject.text.toString().trim()
            val message = txtmessage.text.toString().trim()

            sendEmail(recipient, subject, message)
        }
        btncancel.setOnClickListener {
            finish()
        }
    }

    private fun sendEmail(recipient: String, subject: String, message: String){
        val messageIntent = Intent(Intent.ACTION_SEND)
        messageIntent.data = Uri.parse("mailto:")
        messageIntent.type = "text/plain"
        // EXTRA_EMAIL se trabaja con Array debido a que se pueden agregar varios correos separados por coma (en este caso solo se utilizará la de soporte)
        messageIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        messageIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        messageIntent.putExtra(Intent.EXTRA_TEXT,message)

        try{
            startActivity(Intent.createChooser(messageIntent, "Choose Email Client:"))
        }catch(e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }
}