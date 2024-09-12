package com.example.clase4ytexample_viewmodel.domain

import com.example.clase4ytexample_viewmodel.models.Details
import com.example.clase4ytexample_viewmodel.models.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//Define un método para hacer una solicitud HTTP GET a un endpoint
// que proporciona una lista de películas, permitiendo pasar un número de página como parámetro.
// La respuesta de la API será un objeto de tipo MoviesList


interface ApiInterface {
    @GET("movies?")
    suspend fun  getMovies(         //suspend se usa para asincronismo
        @Query("page")page: Int
    ): Response<MoviesList>

    @GET("movies/{movie_id}")
    suspend fun getDetailsById(
        @Path("movie_id")id: Int
    ):Response<Details>
}