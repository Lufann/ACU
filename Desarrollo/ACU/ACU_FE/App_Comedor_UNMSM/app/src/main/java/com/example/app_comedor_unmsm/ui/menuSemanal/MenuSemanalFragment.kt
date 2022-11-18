package com.example.app_comedor_unmsm.ui.menuSemanal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_comedor_unmsm.R
import kotlinx.android.synthetic.main.fragment_menu_semanal.*

class MenuSemanalFragment : Fragment(R.layout.lista_menu_semanal) {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<AdapterMenuSemanal.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu_semanal, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = AdapterMenuSemanal()
        }
    }
}