package com.rene.universidadcarrera.presentation.universidad

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rene.universidadcarrera.data.Universidad

@Composable
fun UniversidadScreen(navController: NavController) {
    var universidades by remember { mutableStateOf(listOf<Universidad>()) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(
            onClick = { navController.navigate("editar_universidad") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Crear Universidad")
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(universidades) { universidad ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = universidad.nombre, style = MaterialTheme.typography.bodyLarge)
                        Row {
                            Button(onClick = { navController.navigate("editar_universidad/${universidad.id}") }) {
                                Text("Editar")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(onClick = { universidades = universidades - universidad }) {
                                Text("Eliminar")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(onClick = { navController.navigate("carrera") }) {
                                Text("Ver Carreras")
                            }
                        }
                    }
                }
            }
        }
    }
}
