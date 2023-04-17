package com.example.emdb

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ContactActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val btn = findViewById<Button>(R.id.btnInfo)
        val btnFa = findViewById<Button>(R.id.btnFacebook)
        val btnTw = findViewById<Button>(R.id.btnTwitter)
        val btnWa = findViewById<Button>(R.id.btnWhatsApp)
        val btnGm = findViewById<Button>(R.id.btnGmail)
        val btnCo = findViewById<Button>(R.id.btnMessage)

        btn.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.popup_info, null)
            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            myDialog.setCancelable(true)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            myDialog.show()
        }

        btnFa.setOnClickListener {
            val url = "https://www.facebook.com/emdb.2023/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        btnTw.setOnClickListener {
            val url = "https://twitter.com/EMDBoficial"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        btnWa.setOnClickListener {
            val url = "https://wa.me/50361631643"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        btnGm.setOnClickListener {

        }

        btnCo.setOnClickListener {

        }


    }
}