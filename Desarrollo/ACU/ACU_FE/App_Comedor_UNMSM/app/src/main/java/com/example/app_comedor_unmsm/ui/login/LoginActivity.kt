package com.example.app_comedor_unmsm.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import api.HTTPClient
import com.example.app_comedor_unmsm.MainActivity
import com.example.app_comedor_unmsm.R
import com.example.app_comedor_unmsm.databinding.ActivityLoginBinding
import com.example.app_comedor_unmsm.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class LoginActivity : AppCompatActivity() {
    companion object {
        var logout : Boolean = false
    }

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(1000)
        setTheme(R.style.Theme_App_Comedor_UNMSM)
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /** Called when the user taps the Send button */
    fun login(view: View) {

        val newClient = HTTPClient()
        val email: String = findViewById<EditText>(R.id.email_field).text.toString()
        val password: String = findViewById<EditText>(R.id.password_field).text.toString()
        var apiResponse: HttpResponse
        var userExists: Boolean = false
        var userInfo: String = ""
        runBlocking {
            launch {
                apiResponse = newClient.getAccessToken(email, password)
                if(apiResponse.status.value in 200..299){
                    val token:String = apiResponse.body()
                    userExists = true
                    userInfo = newClient.getUserInfo(token)
                }
            }
        }
        if(userExists){
            val intent = Intent(this, MainActivity::class.java)
            println("user info on login $userInfo")
            intent.putExtra("userdata", userInfo)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Correo o contraseña incorrecta", Toast.LENGTH_LONG).show()
        }

    }
    fun changePasswordVisibility(view: View) {
        val passwordField = findViewById<EditText>(R.id.password_field)
        val passwordVisibilityButton = findViewById<ImageView>(R.id.visibilityIcon)

        if (passwordField.inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD) {
            passwordVisibilityButton.setImageResource(R.drawable.ic_outline_visibility_off_24)
            passwordField.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)

        } else {
            passwordVisibilityButton.setImageResource(R.drawable.ic_outline_visibility_24)
            passwordField.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

        }

    }


}