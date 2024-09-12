package com.example.clase4ytexample_viewmodel.paging

interface Pagination <Key, Item> {

    suspend fun loadNextPage()

    fun reset()

}