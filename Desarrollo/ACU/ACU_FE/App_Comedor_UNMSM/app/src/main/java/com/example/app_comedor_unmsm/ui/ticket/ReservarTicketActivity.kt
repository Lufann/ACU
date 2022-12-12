package com.example.app_comedor_unmsm.ui.ticket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.example.app_comedor_unmsm.R

class ReservarTicketActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    var turno_selecionado: String = ""
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservar_ticket)

        val turnos= resources.getStringArray(R.array.turnos)
        val autoCompleteTextView=findViewById<AutoCompleteTextView>(R.id.menuturnos)

        val adapter=ArrayAdapter(applicationContext, R.layout.lista_turnos, R.id.texto_turnos,turnos)
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.onItemClickListener = this

    }

    override fun onItemClick(parent: AdapterView<*>?, View: View?, position: Int, id: Long) {
        turno_selecionado=parent?.getItemAtPosition(position).toString()
        Toast.makeText(this,"Turno $turno_selecionado", Toast.LENGTH_SHORT).show()
    }
}