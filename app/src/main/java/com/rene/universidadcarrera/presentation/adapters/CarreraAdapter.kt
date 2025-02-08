package com.rene.universidadcarrera.presentation.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.rene.universidadcarrera.R
import com.rene.universidadcarrera.data.Carrera
import com.rene.universidadcarrera.presentation.carrera.EditarCarreraScreen

class CarreraAdapter(
    private val carreras: List<Carrera>,
    private val listener: OnItemClickListener,
    private val navController: NavController // Pasar NavController al adaptador
) : RecyclerView.Adapter<CarreraAdapter.CarreraViewHolder>() {

    interface OnItemClickListener {
        fun onDeleteClick(carrera: Carrera)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarreraViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_carrera, parent, false)
        return CarreraViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarreraViewHolder, position: Int) {
        val carrera = carreras[position]
        holder.bind(carrera)
    }

    override fun getItemCount(): Int = carreras.size

    inner class CarreraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreCarrera: TextView = itemView.findViewById(R.id.txtNombreCarrera)
        private val btnEditar: Button = itemView.findViewById(R.id.btnEditarCarrera)
        private val btnEliminar: Button = itemView.findViewById(R.id.btnEliminarCarrera)

        fun bind(carrera: Carrera) {
            nombreCarrera.text = carrera.nombre

            btnEditar.setOnClickListener {
                // Reemplazar Intent por NavController.navigate
                navController.navigate("editar_carrera/${carrera.id}")
            }
            btnEliminar.setOnClickListener { listener.onDeleteClick(carrera) }
        }
    }
}
