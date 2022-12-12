package com.example.app_comedor_unmsm.ui.ticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import api.HTTPClient
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import com.example.app_comedor_unmsm.R
import com.google.gson.Gson
import models.Estudiante
import models.Ticket

class ReservarTicketActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    var turno_selecionado: String = ""
    var  userDataJSON: String?=null
    var CountTicket_1=0
    var CountTicket_2=0
    var CountTicket_3=0
    var cantidad_turnos_1=0
    var cantidad_turnos_2=0
    var cantidad_turnos_3=0
    var ticketExist=false
    var ticketnoSelect=false
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservar_ticket)

        userDataJSON = intent.getStringExtra("userdata")
        val turnos= resources.getStringArray(R.array.turnos)
        val autoCompleteTextView=findViewById<AutoCompleteTextView>(R.id.menuturnos)

        val adapter=ArrayAdapter(applicationContext, R.layout.lista_turnos, R.id.texto_turnos,turnos)
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.onItemClickListener = this

        mostrarTicketBtn()

    }

    fun crearTicket(){
        if (ticketExist==false){
            val newClient = HTTPClient()
            val turnoSeleccionado: String =turno_selecionado
            var ticket_id=0
            if(turnoSeleccionado.isEmpty()){
                Toast.makeText(this, "Por favor seleccione algun turno disponible", Toast.LENGTH_SHORT).show()
                ticketnoSelect=true
                return
            }
            runBlocking {
                launch {
                    newClient.createTicket(ticket_id.toString(),turnoSeleccionado, "20200023")
                }
            }
            Toast.makeText(this, "Turno reservado exitosamente", Toast.LENGTH_SHORT).show()
            ticketnoSelect=false
        }
    }

    fun mostrarTicketBtn() {
        val boton =findViewById<Button>(R.id.botonreservar)

        boton.setOnClickListener{
            crearTicket()
            val intentreservar = Intent(this,MostrarTicketActivity::class.java)
            startActivity(intentreservar)
        }
    }


    override fun onItemClick(parent: AdapterView<*>?, View: View?, position: Int, id: Long) {
        turno_selecionado=parent?.getItemAtPosition(position).toString()
        Toast.makeText(this,"Turno $turno_selecionado", Toast.LENGTH_SHORT).show()
    }
}