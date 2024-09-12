package com.example.clase4ytexample_viewmodel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mkrdeveloper.movieinfoappmvvm.navigation.BannerScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController =  navController, startDestination =  "Banner screen") {
        composable("Banner screen"){
            BannerScreen(navController = navController)
        }

        composable("Home screen"){
            HomeScreen(navController = navController)
        }

        composable("Details screen/{id}",
                arguments= listOf(
                    navArgument(
                        name = "id"
                    ){
                        type = NavType.IntType
                    }
                )
            ){id->
            id.arguments?.getInt("id")?.let{
                id1->
            DetailsScreen(id =id1)
            }
        }

    }
}


//NavHost: Es el contenedor principal que define el flujo de navegación.
// Dentro de él se especifican las pantallas disponibles y el destino inicial.


//composable(): Define cada pantalla dentro del sistema de navegación,
// asociando una clave única (como "Banner screen" o "Home screen") con el composable que representa esa pantalla.

//rememberNavController(): Crea un controlador de navegación que recuerda
// el estado de navegación en la app.
