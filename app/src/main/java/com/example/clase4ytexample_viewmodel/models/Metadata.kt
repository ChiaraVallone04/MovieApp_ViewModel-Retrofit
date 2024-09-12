package com.example.clase4ytexample_viewmodel.models


//Pagination
data class Metadata(
    val current_page: String,
    val page_count: Int,    //total paginas
    val per_page: Int,      //cantidad de elementos que se devuelven por página.
    val total_count: Int    //número total de elementos disponibles en la consulta
)