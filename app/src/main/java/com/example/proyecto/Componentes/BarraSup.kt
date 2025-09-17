package com.example.proyecto.Componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

// BarraSuperior.kt
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSup(nombreUsuario: String) {
    TopAppBar(
        title = { Text("Hola, $nombreUsuario 👋") },
        actions = {
            IconButton(onClick = { /* cerrar sesión */ }) {
                Icon(Icons.Default.ExitToApp, contentDescription = "Cerrar sesión")
            }
        }
    )
}
