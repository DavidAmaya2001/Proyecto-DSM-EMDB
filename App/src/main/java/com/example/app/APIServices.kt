package com.example.app

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIServices {
    @GET("/en/API/SearchMovie/{apiKey}/{expression}")
    fun searchMovies(@Path("expression") expression: String, @Path("apiKey") apiKey: String = "k_09b1f803"): Call<SearchResponse>

    @GET("/{lang}/API/Title/{apiKey}/{id}/Trailer")
    fun getMovieDetails(
        @Path("id") id: String,
        @Path("lang") lang: String?,
        @Path("apiKey") apiKey: String = "k_09b1f803",
        @Query("options") options: String = "Full"
    ): Call<TitleResponse>


    @GET("/{lang}/API/SearchSeries/{apiKey}/{expression}")
    fun searchSeries(
        @Path("lang") lang: String?,
        @Path("expression") expression: String?,
        @Path("apiKey") apiKey: String? = "k_09b1f803"
    ): Call<SearchResponseSeries>

    @GET("/es/API/AdvancedSearch/{apiKey}/")
    fun searchByGenre(

        @Path("apiKey") apiKey: String,
        @Query("parameters") parameters: String
    ): Call<Root>

    @GET("/{lang}/API/YouTubeTrailer/{apiKey}/{id}")
    fun getTrailerUrl(
        @Path("id") id: String,
        @Path("lang") lang: String? = "es",
        @Path("apiKey") apiKey: String = "k_09b1f803"

    ): Call<TrailerYT>
}