package com.rene.universidadcarrera.presentation.carrera

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rene.universidadcarrera.data.Carrera

@Composable
fun CarreraScreen(navController: NavController) {
    var carreras by remember { mutableStateOf(listOf<Carrera>()) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(
            onClick = { navController.navigate("editar_carrera") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Crear Carrera")
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(carreras) { carrera ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = carrera.nombre, style = MaterialTheme.typography.bodyLarge)
                        Row {
                            Button(onClick = { navController.navigate("editar_carrera/${carrera.id}") }) {
                                Text("Editar")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(onClick = { carreras = carreras - carrera }) {
                                Text("Eliminar")
                            }
                        }
                    }
                }
            }
        }
    }
}

