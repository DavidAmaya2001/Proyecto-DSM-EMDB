package com.example.app.ui.movies

import com.google.gson.annotations.SerializedName

data class MostPopularMovie(
    val id: String,
    val rank: Int,
    val fullTitle: String,
    val image: String,
    val imDbRating: String,

    @SerializedName("poster_path")
    val posterPath: String?,

    val overview: String,
    @SerializedName("vote_average")
    val voteAverage: Double,

)