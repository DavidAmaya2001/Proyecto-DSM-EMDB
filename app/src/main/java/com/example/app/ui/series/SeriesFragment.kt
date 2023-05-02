package com.example.app.ui.series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.app.databinding.FragmentContactsBinding
import com.example.app.databinding.FragmentSeriesBinding
import com.example.app.ui.contacts.ContactsViewModel

class SeriesFragment : Fragment() {

    private var _binding: FragmentSeriesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val seriesViewModel =
            ViewModelProvider(this).get(SeriesViewModel::class.java)

        _binding = FragmentSeriesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //AQUÍ SE EMPIEZA A PROGRAMAR


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}