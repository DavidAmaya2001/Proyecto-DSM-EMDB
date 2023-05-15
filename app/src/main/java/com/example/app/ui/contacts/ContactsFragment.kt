package com.example.app.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.app.databinding.FragmentContactsBinding

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.widget.Button
import com.example.app.ContactEmailActivity
import com.example.app.ContactMessageActivity
import com.example.app.R

class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        val contactsViewModel =
            ViewModelProvider(this).get(ContactsViewModel::class.java)

        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Codigo de Ejecución de los controladores


        val btn:   Button = root.findViewById(R.id.btnInfo)
        val btnFa: Button = root.findViewById(R.id.btnFacebook)
        val btnTw: Button = root.findViewById(R.id.btnTwitter)
        val btnWa: Button = root.findViewById(R.id.btnWhatsApp)
        val btnGm: Button = root.findViewById(R.id.btnGmail)
        val btnSMS: Button = root.findViewById(R.id.btnSMS)


        btn.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.popup_info, null)
            val myDialog = Dialog(btn.context)
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
            val intent = Intent(btnGm.context,ContactEmailActivity::class.java)
            startActivity(intent)
        }

        btnSMS.setOnClickListener {
            val intent = Intent(btnSMS.context,ContactMessageActivity::class.java)
            startActivity(intent)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}