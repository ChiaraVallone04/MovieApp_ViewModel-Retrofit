package com.example.clase4ytexample_viewmodel.viewModel

import com.example.clase4ytexample_viewmodel.models.Details
import com.example.clase4ytexample_viewmodel.models.MoviesList
import com.example.clase4ytexample_viewmodel.utils.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getMovieList(page:Int):Response<MoviesList>{
        return RetrofitInstance.api.getMovies(page)
    }

    suspend fun getDetailsById(id: Int):Response<Details>{
        return RetrofitInstance.api.getDetailsById(id = id)
    }
}