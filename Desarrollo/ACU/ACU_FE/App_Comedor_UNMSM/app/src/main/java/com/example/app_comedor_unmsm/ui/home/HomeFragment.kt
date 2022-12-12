package com.example.app_comedor_unmsm.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.app_comedor_unmsm.MostrarTicketActivity
import com.example.app_comedor_unmsm.R
import com.example.app_comedor_unmsm.ReservarTicketActivity
import com.example.app_comedor_unmsm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val bind = FragmentHomeBinding.inflate(layoutInflater)
       bind.showButton.setOnClickListener{
            val intent = Intent (this@HomeFragment.requireContext(), MostrarTicketActivity::class.java)
            startActivity((intent))
       }
        bind.buttonMostrarTicket.setOnClickListener{
            val intent = Intent (this@HomeFragment.requireContext(), MostrarTicketActivity::class.java)
            startActivity((intent))
        }

        bind.buttonReservarTicket.setOnClickListener {
            val intent = Intent (this@HomeFragment.requireContext(), ReservarTicketActivity::class.java)
            startActivity((intent))
        }
        return bind.root
    }

}

