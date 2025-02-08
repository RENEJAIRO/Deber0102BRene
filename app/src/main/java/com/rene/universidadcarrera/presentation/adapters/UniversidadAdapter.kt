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
import com.rene.universidadcarrera.data.Universidad
import com.rene.universidadcarrera.presentation.universidad.EditarUniversidadScreen


class UniversidadAdapter(
    private val universidades: List<Universidad>,
    private val listener: OnItemClickListener,
    private val navController: NavController // Pasar NavController al adaptador
) : RecyclerView.Adapter<UniversidadAdapter.UniversidadViewHolder>() {

    interface OnItemClickListener {
        fun onDeleteClick(universidad: Universidad)
        fun onViewCarrerasClick(universidad: Universidad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversidadViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_universidad, parent, false)
        return UniversidadViewHolder(view)
    }

    override fun onBindViewHolder(holder: UniversidadViewHolder, position: Int) {
        val universidad = universidades[position]
        holder.bind(universidad)
    }

    override fun getItemCount(): Int = universidades.size

    inner class UniversidadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreUniversidad: TextView = itemView.findViewById(R.id.txtNombreUniversidad)
        private val btnEditar: Button = itemView.findViewById(R.id.btnEditarUniversidad)
        private val btnEliminar: Button = itemView.findViewById(R.id.btnEliminarUniversidad)
        private val btnVerCarreras: Button = itemView.findViewById(R.id.btnVerCarreras)

        fun bind(universidad: Universidad) {
            nombreUniversidad.text = universidad.nombre

            btnEditar.setOnClickListener {
                // Reemplazar Intent por NavController.navigate
                navController.navigate("editar_universidad/${universidad.id}")
            }
            btnEliminar.setOnClickListener { listener.onDeleteClick(universidad) }
            btnVerCarreras.setOnClickListener { listener.onViewCarrerasClick(universidad) }
        }
    }
}
