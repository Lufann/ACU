package com.example.app_comedor_unmsm.ui.menuSemanal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_comedor_unmsm.R

class AdapterMenuSemanal: RecyclerView.Adapter<AdapterMenuSemanal.ViewHolder>() {
    val dates = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado")
    val food = arrayOf("Pollo a la brasa", "Lomo Saltado", "Tacacho con Cecina",
        "Arroz con Pollo", "Arroz a la jardinera", "Pure de papas")
    val images = intArrayOf(
        R.drawable.pollo, R.drawable.pollo,
        R.drawable.tacacho, R.drawable.arrozpollo,
        R.drawable.jardinera, R.drawable.pure
    )


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.lista_menu_semanal, viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemDate.text = dates[i]
        viewHolder.itemFood.text = food[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return dates.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemDate: TextView
        var itemFood: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemDate = itemView.findViewById(R.id.item_date)
            itemFood = itemView.findViewById(R.id.item_food)
        }
    }
}