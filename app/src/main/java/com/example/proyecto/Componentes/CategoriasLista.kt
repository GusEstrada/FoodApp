package com.example.proyecto.Componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.proyecto.Data.categoriaslist

@Composable
fun CategoriasLista() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        categoriaslist.forEach { categoria ->
            Text(
                text = categoria.nombre,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )
        }
    }
}
