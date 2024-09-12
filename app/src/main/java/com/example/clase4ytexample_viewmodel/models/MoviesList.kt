package com.example.clase4ytexample_viewmodel.models


//Cada elemento en la lista es un objeto de la clase Data

data class MoviesList(
    val data: List<Data>,       //La clase Data tiene la informacion de la pelicula
    val metadata: Metadata      //Contiene la paginacion
)