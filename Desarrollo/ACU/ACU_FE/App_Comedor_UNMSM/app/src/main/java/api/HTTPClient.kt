package api

import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import models.bugs
import models.Ticket
import models.tokens
import models.Estudiante
import java.text.SimpleDateFormat
import java.util.*

class HTTPClient {

    private val client = HttpClient(CIO) {
        install(HttpRequestRetry) {
            retryOnServerErrors(maxRetries = 5)
            exponentialDelay()
        }
    }
    private val baseUrl = "https://gcc-comedor-api.onrender.com/docs"
    private val c = Calendar.getInstance()

    suspend fun getDishInfo(): String {
        val url = baseUrl + "/platillos/get/" + (c.get(Calendar.DAY_OF_WEEK)-1).toString()
        //val data: String = Gson().toJson(dish, Dish::class.java)
        val response: HttpResponse = client.get(url)
        val response_data: String = response.body<String>().toString()
        return response_data
    }

    suspend fun getWeekDishInfo(i:Int): String {
        val url = baseUrl + "/platillos/get/" + i.toString()
        val response: HttpResponse = client.get(url)
        val response_data: String = response.body<String>().toString()
        return response_data
    }

    suspend fun getTicketInfo(code: String): String{
        val url= baseUrl + "/tickets/get-ticket-info/" + code
        val response: HttpResponse=client.get(url)
        val response_data: String = response.body<String>().toString()
        return response_data
    }

    suspend fun getTicketCount(shift: String): Int{
        val url= baseUrl + "/tickets/get-shift-tickets/" + shift
        val response: HttpResponse=client.get(url)
        val response_data: Int=response.body<Int>().toInt()
        return response_data
    }

    suspend fun createTicket(codigo_ticket: String, numero_turno: String, codigo_estudiante: String)
    {
        val currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
        val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())

        val newTicket = Ticket(codigo_ticket, numero_turno, false, codigo_estudiante)
        val url= baseUrl + "/tickets/create-ticket/"

        val data: String = Gson().toJson(newTicket)
        val response: HttpResponse = client.post(url) {
            contentType(ContentType.Application.Json)
            setBody(data)
        }
        println("Reporte de estado de Ticket: $response.status")
        client.close()
    }

    suspend fun createBugReport(description: String) {
        val currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
        val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())

        val newBug = bugs(currentDate, currentTime, description)
        val url = baseUrl + "/bugs/create-bug/"

        val data: String = Gson().toJson(newBug)
        val response: HttpResponse = client.post(url) {
            contentType(ContentType.Application.Json)
            setBody(data)
        }
        println("reporte de estado de bug: $response.status")
        client.close()
    }



    suspend fun getAccessToken(email: String, password: String): HttpResponse {
        val url = baseUrl + "/login/get-token"
        val response: HttpResponse = client.submitForm(
            url,
            formParameters = Parameters.build {
                append("grant_type", "")
                append("username", email)
                append("password", password)
                append("scope", "")
                append("client_id", "")
                append("client_secret", "")

            }
        )
        val data_str: String = response.body<String>().toString()
        return response
    }

    suspend fun getUserInfo(token: String): String {
        val url = baseUrl + "/estudiante/read-estudiante"
        val data = Gson().fromJson(token, tokens::class.java)
        val response: HttpResponse = client.get(url) {
            header("Authorization", "Bearer ${data.access_token}")
        }
        val response_data: String = response.body<String>().toString()
       // val userInfo = Gson().fromJson(response_data, User::class.java)
        return response_data

    }
}



