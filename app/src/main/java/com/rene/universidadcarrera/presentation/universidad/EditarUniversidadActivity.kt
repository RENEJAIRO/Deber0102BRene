package com.rene.universidadcarrera.presentation.universidad

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun EditarUniversidadScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize() // Asegúrate de que la columna ocupe toda la pantalla
            .padding(16.dp), // Aplica padding correctamente
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título de la pantalla
        Text(
            text = "Editar Universidad",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp) // Espaciado adicional para el título
        )

        // Aquí puedes agregar los campos para editar los datos de la universidad
        TextField(
            value = "", // Aquí iría el valor actual, si ya tienes un estado
            onValueChange = {}, // Implementa el cambio de valor aquí
            label = { Text("Nombre de la Universidad") },
            modifier = Modifier.fillMaxWidth() // Asegúrate de que el TextField ocupe todo el ancho disponible
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espaciado entre los campos

        Button(
            onClick = { navController.popBackStack() }, // Regresar a la pantalla anterior
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Guardar")
        }
    }
}
