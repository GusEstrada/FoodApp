package com.example.proyecto.Componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.proyecto.Data.categoriaslist
import com.example.proyecto.Data.restauranteslist
import com.example.proyecto.Data.comidasEjemplolist
import com.example.proyecto.Models.Categoria
import com.example.proyecto.Models.Comida
import com.example.proyecto.Models.Restaurante
import com.example.proyecto.ui.theme.ProyectoTheme
import com.example.proyecto.R

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

        Text(
            text = "COMIDAS RECOMENDADAS",
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(8.dp)) {
            items(comidasEjemplolist) { comida ->
                TarjetaComida(comida = comida)
            }
        }
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
                    .background(Color(0xFFFF9800))
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
fun TarjetaCategoria(categoria: Categoria) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .width(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = categoria.image,
                contentDescription = categoria.nombre,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = categoria.nombre,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
    }
}

@Composable
fun ListaCategorias() {
    LazyRow(modifier = Modifier.padding(horizontal = 8.dp)) {
        items(categoriaslist) { categoria ->
            TarjetaCategoria(categoria = categoria)
        }
    }
}

@Composable
fun TarjetaRestaurante(restaurante: Restaurante) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .width(140.dp)
            .clip(MaterialTheme.shapes.medium)

    ) {
        AsyncImage(
            model = restaurante.image,
            contentDescription = restaurante.nombre,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = restaurante.nombre,
            modifier = Modifier.padding(8.dp),
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun ListaRestaurantes() {
    LazyRow(modifier = Modifier.padding(horizontal = 8.dp)) {
        items(restauranteslist) { restaurante ->
            TarjetaRestaurante(restaurante = restaurante)
        }
    }
}

@Composable
fun TarjetaComida(comida: Comida) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .height(180.dp)
            .clip(MaterialTheme.shapes.medium)

            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = comida.image,
                contentDescription = comida.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                Text(text = comida.nombre, fontWeight = FontWeight.Bold)
                Text(text = "⭐ ${comida.calificacion} - \$${comida.precio}")
            }
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
