package com.example.proyecto.Componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto.Data.categoriaslist
import com.example.proyecto.Data.restauranteslist
import com.example.proyecto.ui.theme.ProyectoTheme

@Composable
fun PantallaPrincipal(nombreUsuario: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        BarraSuperior(nombreUsuario)

        Text(
            text = "NUESTRAS CATEGORÍAS",
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        ListaCategorias()

        Text(
            text = "BUSCA LOS MEJORES RESTAURANTES",
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        ListaRestaurantes()
    }
}

@Composable
fun BarraSuperior(nombreUsuario: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFF9800)) // naranja
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "usuario",
                    tint = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = "Hola, $nombreUsuario", fontWeight = FontWeight.Bold)
            }
        }

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.ExitToApp,
                contentDescription = "Cerrar sesión"
            )
        }
    }
}

@Composable
fun ListaCategorias() {
    LazyRow(modifier = Modifier.padding(horizontal = 8.dp)) {
        items(categoriaslist.size) { index ->
            Text(
                text = categoriaslist[index].nombre,
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color(0xFFE0E0E0))
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun ListaRestaurantes() {
    LazyRow(modifier = Modifier.padding(horizontal = 8.dp)) {
        items(restauranteslist.size) { index ->
            Text(
                text = restauranteslist[index].nombre,
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color(0xFFD1C4E9))
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPreview() {
    ProyectoTheme {
        PantallaPrincipal(nombreUsuario = "Gustavo")
    }
}
