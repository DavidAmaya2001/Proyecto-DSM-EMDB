package com.example.app.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.app.databinding.FragmentMoviesBinding

import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.webkit.WebView
import android.widget.ImageView
import com.example.app.R

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://imdb-api.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val moviesViewModel =
            ViewModelProvider(this).get(MoviesViewModel::class.java)

        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //AQUÍ SE EMPIEZA A PROGRAMAR

        //Para obtener resultados de una pelicula con el nombre que se busca


        apiService.getMostPopularMovies()
            .enqueue(object : Callback<ApiService.MostPopularMoviesResponse> {
                override fun onResponse(
                    call: Call<ApiService.MostPopularMoviesResponse>,
                    response: Response<ApiService.MostPopularMoviesResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            val resultTextView = root.findViewById<TextView>(R.id.result_text_view)
                            var resultString = ""
                            for (movie in responseBody.items) {
                                resultString += "ID: ${movie.id}\n"
                                resultString += "Title: ${movie.title}\n"
                                resultString += "Movie: ${movie.image}\n"

                                // Use Picasso to load and display the image from the URL
                                val url = "${movie.image}"

                                if (!movie.image.isNullOrEmpty()) {
                                    Log.e("MainActivity", "${movie.image}")
                                    val imageView = root.findViewById<ImageView>(R.id.imageView1)
                                    Picasso.get().load(movie.image).resize(150, 150).into(imageView)
                                }

                                resultString += "\n\n"
                            }
                            resultTextView.text = resultString
                        }

                    }
                }

                override fun onFailure(
                    call: Call<ApiService.MostPopularMoviesResponse>,
                    t: Throwable
                ) {
                    Log.e("MainActivity", "Error en la llamada a la API", t)
                }
            })
        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

    interface ApiService {

        @GET("/es/API/MostPopularMovies/k_09b1f803")
        fun getMostPopularMovies(

        ): Call<MostPopularMoviesResponse>
        //Most pupular data class
        data class MostPopularMoviesResponse(
            val items: List<MostPopularMovie>,
            val errorMessage: String
        )


        @GET("/en/API/SearchMovie/{apiKey}/{expression}")
        fun searchMovies(
            @Path("expression") expression: String,
            @Path("apiKey") apiKey: String = "k_09b1f803"
        ): Call<SearchResponse>

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


    //data class para funcion searchMovies

    data class MostPopularMovie(
        val id: String,
        @SerializedName("poster_path")
        val posterPath: String?,
        val title: String,
        val overview: String,
        @SerializedName("vote_average")
        val voteAverage: Double,
        val image: String
    )

    data class Movie(
        val id: String,
        val resultType: String,
        val image: String,
        val title: String,
        val description: String
    )

    data class SearchResponse(
        val searchType: String,
        val expression: String,
        val results: List<Movie>,
        val errorMessage: String
    )

//data class para funcion searchSeries

    data class SearchResponseSeries(
        val searchType: String,
        val expression: String,
        val results: List<Serie>,
        val errorMessage: String
    )


    data class Serie(
        val id: String,
        val resultType: String,
        val image: String,
        val title: String,
        val description: String
    )


    //data class para funcion getMovieDetails, sirve para peliculas y series
    data class TitleResponse(
        val fullTitle: String,
        val type: String,
        val image: String?,
        val runtimeStr: String?,
        val plot: String,
        val plotLocal: String?,
        val directors: String?,
        val trailer: Trailer,
    )

    data class Trailer(
        val link: String,
        val linkEmbed: String
    )

    //data class para trailer de YouTube
    data class TrailerYT(
        val videoUrl: String
    )


    //data class para funcion searchByGenre
    data class AdvSearch(
        val queryString: String,
        val results: List<AdvancedSearchResult>,
        val errorMessage: String
    )

    data class AdvancedSearchResult(
        val id: String,
        val title: String,
        val description: String,
        val image: String?,
        val releaseDate: String?,
        val genre: String
    )

    data class Root(
        val queryString: String,
        val results: List<Result>,
        val errorMessage: Any?,
    )

    data class Result(
        val id: String,
        val image: String,
        val title: String,
        val description: String,
        val runtimeStr: String?,
        val genres: String,
        val genreList: List<GenreList>,
        val contentRating: String?,
        val imDbRating: String?,
        val imDbRatingVotes: String?,
        val metacriticRating: String?,
        val plot: String?,
        val stars: String?,
        val starList: List<StarList>?,
    )

    data class GenreList(
        val key: String,
        val value: String,
    )

    data class StarList(
        val id: String,
        val name: String,
    )


