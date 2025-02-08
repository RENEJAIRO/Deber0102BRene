package com.rene.universidadcarrera.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rene.universidadcarrera.data.Carrera
import com.rene.universidadcarrera.repository.CarreraRepository

class CarreraViewModel : ViewModel() {
    private val repository = CarreraRepository()
    private val _carreras = MutableLiveData<List<Carrera>>()
    val carreras: LiveData<List<Carrera>> = _carreras

    fun loadCarreras(universidadId: String) {
        _carreras.value = repository.getAllByUniversidad(universidadId)  // Cambiado el nombre del método
    }

    fun addCarrera(carrera: Carrera) {
        repository.add(carrera)  // Cambiado el nombre del método
        _carreras.value = repository.getAllByUniversidad(carrera.universidadId)
    }

    fun deleteCarrera(carrera: Carrera) {
        repository.remove(carrera)  // Cambiado el nombre del método
        _carreras.value = repository.getAllByUniversidad(carrera.universidadId)
    }
}

