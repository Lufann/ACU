package com.example.app_comedor_unmsm.ui.ticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.app_comedor_unmsm.MainActivity
import com.example.app_comedor_unmsm.R
import com.example.app_comedor_unmsm.databinding.ActivityMostrarTicketBinding
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder

class MostrarTicketActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMostrarTicketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_ticket)

        val bundle=intent.extras
        val boton = findViewById<Button>(R.id.buttonVolverMostrarTicket)

        boton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        //val userInfo = Gson().fromJson(data, User::class.java)
        val textViewUserName = findViewById<TextView>(R.id.textUsernameMostrar)
        val textViewUserCode = findViewById<TextView>(R.id.textCodigoMostrar)
        //val textViewUserNumber = findViewById<TextView>(R.id.textNumeroMostrar)
        val imgQr = findViewById<ImageView>(R.id.qrCode)
        val imgbarras = findViewById<ImageView>(R.id.imgbarras)
        val profileImage = findViewById<ImageView>(R.id.imageUser)
        /*Picasso.get().load(userInfo.profile_photo_url).into(profileImage)
        textViewUserName.setText("${userInfo.names} ${userInfo.lastnames}")
        textViewUserCode.setText("${userInfo.code}")*/
        //textViewUserNumber.setText("${userInfo.number}")
        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.encodeBitmap(
                //userInfo.code,
                "Hello there!",
                BarcodeFormat.QR_CODE,
                750,
                750
            )
            imgQr.setImageBitmap(bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap1 = barcodeEncoder.encodeBitmap(
                //userInfo.code,
                "Hello there!",
                BarcodeFormat.CODE_39,
                400,
                80
            )
            imgbarras.setImageBitmap(bitmap1)
        } catch (e: Exception) {
            e.printStackTrace()
        }



    }

}