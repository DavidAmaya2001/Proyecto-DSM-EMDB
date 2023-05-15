package com.example.app.ui.movies

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET("/es/API/MostPopularMovies/k_1jxl10d9")

    fun getMostPopularMovies(): Call<MoviesResponse>
    //Most pupular data class
    data class MoviesResponse(
        val items: List<MostPopularMovie>,
        val errorMessage: String
    )



}