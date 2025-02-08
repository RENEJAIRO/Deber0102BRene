package com.rene.universidadcarrera.repository

import com.rene.universidadcarrera.data.Universidad


class UniversidadRepository {
    private val universidades = mutableListOf<Universidad>()

    fun getAll(): List<Universidad> = universidades
    fun add(universidad: Universidad) = universidades.add(universidad)
    fun remove(universidad: Universidad) = universidades.remove(universidad)
    fun update(updatedUniversidad: Universidad) {
        val index = universidades.indexOfFirst { it.id == updatedUniversidad.id }
        if (index != -1) universidades[index] = updatedUniversidad
    }
}