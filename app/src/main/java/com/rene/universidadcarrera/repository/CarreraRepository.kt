package com.rene.universidadcarrera.repository

import com.rene.universidadcarrera.data.Carrera

class CarreraRepository {
    private val carreras = mutableListOf<Carrera>()

    fun getAllByUniversidad(universidadId: String): List<Carrera> =
        carreras.filter { it.universidadId == universidadId }

    fun add(carrera: Carrera) = carreras.add(carrera)
    fun remove(carrera: Carrera) = carreras.remove(carrera)
    fun update(updatedCarrera: Carrera) {
        val index = carreras.indexOfFirst { it.id == updatedCarrera.id }
        if (index != -1) carreras[index] = updatedCarrera
    }
}

