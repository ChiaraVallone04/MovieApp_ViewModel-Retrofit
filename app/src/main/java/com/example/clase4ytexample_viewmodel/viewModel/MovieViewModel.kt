package com.example.clase4ytexample_viewmodel.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clase4ytexample_viewmodel.models.Data
import com.example.clase4ytexample_viewmodel.models.Details
import com.example.clase4ytexample_viewmodel.paging.PaginationFactory
import kotlinx.coroutines.launch


//ViewModel incluye la logica de paginacion y la interaccion con el repositorio de datos

class MovieViewModel : ViewModel() {
    private val repository = Repository()       //realiza las peticiones a la API para obtener la lista de películas
    var state by mutableStateOf(ScreenState()) //para cambiar la paginacion
    var id by mutableIntStateOf(0)

    private val pagination = PaginationFactory(
        initialPage = state.page,
        onLoadUpdated = {
            state = state.copy(
                isLoading = it
            )
        },
        onRequest = {
            nextPage -> repository.getMovieList(nextPage)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = {items, newPage ->
            state = state.copy(
                movies = state.movies + items.data,
                page = newPage,
                endReached = state.page == 25
            )
        }
    )

    /*init{
        viewModelScope.launch {
            val response = repository.getMovieList(state.page)
            state = state.copy(
                movies = response.body()!!.data
            )
        }
    }*/

    init{
        loadNextItems()
    }

    fun loadNextItems(){
        viewModelScope.launch {
            pagination.loadNextPage()
        }
    }

    fun getDetailsById() {
        viewModelScope.launch {
            try {
                val response = repository.getDetailsById(id = id)
                if (response.isSuccessful) {
                    state = state.copy(
                        detailsData = response.body()!!
                    )
                }
            } catch (e: Exception) {
                state = state.copy(
                    error = e.message
                )
            }
        }
    }
}


data class ScreenState(
    val movies: List<Data> = emptyList(),
    val page: Int = 1,
    val detailsData: Details = Details(),
    val endReached: Boolean = false,
    val error: String? = null,
    val isLoading: Boolean = false,
)

//state es una propiedad en MovieViewModel que contiene el estado actual de la pantalla.
//mutableStateOf() convierte state en un valor observable que, cuando cambia, actualiza la UI.
//ScreenState es una clase que define el estado de la pantalla, con dos propiedades principales: la lista de películas (movies) y el número de página (page).
//El ViewModel obtiene los datos de las películas y actualiza el state con los nuevos datos.
//La UI se actualiza automáticamente cuando cambia el state gracias a Jetpack Compose.
