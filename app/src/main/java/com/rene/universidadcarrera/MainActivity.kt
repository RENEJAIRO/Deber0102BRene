package com.rene.universidadcarrera

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import androidx.navigation.compose.NavHost
import com.rene.universidadcarrera.presentation.universidad.UniversidadScreen
import com.rene.universidadcarrera.presentation.universidad.EditarUniversidadScreen
import com.rene.universidadcarrera.presentation.carrera.CarreraScreen
import com.rene.universidadcarrera.presentation.carrera.EditarCarreraScreen
import com.rene.universidadcarrera.ui.theme.UniversidadCarreraAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UniversidadCarreraAppTheme {
                UniversidadCarreraApp()
            }
        }
    }
}

@Composable
fun UniversidadCarreraApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "universidad") {
        composable("universidad") { UniversidadScreen(navController) }
        composable("carrera") { CarreraScreen(navController) }
        composable("editar_universidad") { EditarUniversidadScreen(navController) }
        composable("editar_carrera") { EditarCarreraScreen(navController) }
    }
}


