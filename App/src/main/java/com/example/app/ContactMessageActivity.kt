package com.example.app

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

lateinit var txtphone: EditText
lateinit var txtContent: EditText
lateinit var btnSend: Button


class ContactMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_message)

        txtphone = findViewById(R.id.txtPhoneNumber)
        txtContent = findViewById(R.id.txtMessageContent)
        btnSend = findViewById(R.id.btnSendSMS)
        var btncancel = findViewById<Button>(R.id.btnReturnSMS)



        btnSend.setOnClickListener {
            if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
                sendSMS()
            }
            else{
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS), 100)
            }
        }

        btncancel.setOnClickListener {
            finish()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode ==100 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            sendSMS()
        }
        else{
            Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun sendSMS() {
        val phone = "61631643"
        val message = txtContent.text.toString()

        if(!phone.isEmpty() && !message.isEmpty()){
            val smsManager = SmsManager.getDefault()

            smsManager.sendTextMessage(phone,null,message,null,null)

            Toast.makeText(this, "SMS sent successfully", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Please enter Message to send", Toast.LENGTH_SHORT).show()
        }
    }
}