package com.example.proyecto.Componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun CardsFood(titulo: String) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .height(120.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.LightGray)
            .fillMaxWidth()
    ) {
        Text(titulo, modifier = Modifier.align(Alignment.Center))
    }
}
