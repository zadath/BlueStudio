package com.lions.bluestudio.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lions.bluestudio.R
import com.lions.bluestudio.data.models.Movie
import com.lions.bluestudio.data.models.MovieResponse
import com.lions.bluestudio.data.services.MovieApiInterface
import com.lions.bluestudio.data.services.MovieApiService
import com.lions.bluestudio.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*rv_movies_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies : List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movies)
        }*/
    }



    private fun getMovieData(callback: (List<Movie>) -> Unit){
        /*val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

        })*/
    }
}