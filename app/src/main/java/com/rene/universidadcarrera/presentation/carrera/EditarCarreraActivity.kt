package com.rene.universidadcarrera.presentation.carrera

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun EditarCarreraScreen(navController: NavController) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Editar Carrera", fontSize = 20.sp)
        // Agrega aquí campos para editar los datos de la carrera

        Button(onClick = { navController.popBackStack() }) {
            Text("Guardar")
        }
    }
}
