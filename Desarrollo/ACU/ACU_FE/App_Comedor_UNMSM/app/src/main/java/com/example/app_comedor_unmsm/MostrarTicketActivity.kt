package com.example.app_comedor_unmsm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.app_comedor_unmsm.databinding.ActivityMostrarTicketBinding
import kotlinx.android.synthetic.main.fragment_home.*

class MostrarTicketActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMostrarTicketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_ticket)

        val bundle=intent.extras
        val boton = findViewById<Button>(R.id.buttonVolverMostrarTicket)

        boton.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

}