package com.rene.universidadcarrera.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rene.universidadcarrera.data.Universidad
import com.rene.universidadcarrera.repository.UniversidadRepository

class UniversidadViewModel : ViewModel() {
    private val repository = UniversidadRepository()
    private val _universidades = MutableLiveData<List<Universidad>>(repository.getAll())  // Método corregido
    val universidades: LiveData<List<Universidad>> = _universidades

    fun addUniversidad(universidad: Universidad) {
        repository.add(universidad)  // Método corregido
        _universidades.value = repository.getAll()
    }

    fun deleteUniversidad(universidad: Universidad) {  // Cambié el parámetro de id a Universidad
        repository.remove(universidad)  // Método corregido
        _universidades.value = repository.getAll()
    }
}
