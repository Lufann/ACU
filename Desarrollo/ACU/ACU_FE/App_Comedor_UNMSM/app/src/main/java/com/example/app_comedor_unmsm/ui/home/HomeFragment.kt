package com.example.app_comedor_unmsm.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app_comedor_unmsm.ui.ticket.MostrarTicketActivity
import com.example.app_comedor_unmsm.ui.ticket.ReservarTicketActivity
import com.example.app_comedor_unmsm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
       val bind = FragmentHomeBinding.inflate(layoutInflater)
       bind.MostrarTicketBoton.setOnClickListener{
            val intent = Intent (this@HomeFragment.requireContext(), MostrarTicketActivity::class.java).apply {  }
            startActivity((intent))
       }
        bind.ReservarTicketBoton.setOnClickListener {
            val intent=Intent (this@HomeFragment.requireContext(), ReservarTicketActivity::class.java)
            startActivity(intent)
        }

        return bind.root
    }

}

