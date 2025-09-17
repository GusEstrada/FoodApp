package com.example.proyecto.Data

import com.example.proyecto.Models.Categoria
import com.example.proyecto.Models.Comida
import com.example.proyecto.Models.Restaurante

val categoriaslist = listOf(
    Categoria("Rápida"),
    Categoria("China"),
    Categoria("Italiana"),
    Categoria("Mexicana"),
    Categoria("Postres")
)

val restauranteslist = listOf(
    Restaurante("Burger King"),
    Restaurante("McDonald's"),
    Restaurante("KFC"),
    Restaurante("Taco Bell"),
    Restaurante("Domino's")
)

val comidasEjemplolist = listOf(
    Comida("Whopper", 4.5, 99.8),
    Comida("Chicken Fries", 4.3, 59.8),
    Comida("Big Mac", 4.6, 79.8),
    Comida("McFlurry", 4.7, 49.8),
    Comida("Pizza Pepperoni", 4.4, 89.8)
)
