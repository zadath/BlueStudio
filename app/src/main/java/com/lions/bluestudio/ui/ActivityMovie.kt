package com.lions.bluestudio.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lions.bluestudio.R
import com.lions.bluestudio.data.models.Movie
import com.lions.bluestudio.data.models.MovieResponse
import com.lions.bluestudio.data.models.NowMovies
import com.lions.bluestudio.data.models.NowMoviesResponse
import com.lions.bluestudio.data.services.MovieApiInterface
import com.lions.bluestudio.data.services.MovieApiService
import com.lions.bluestudio.data.services.MovieApiServiceNow
import com.lions.bluestudio.data.services.NowMovieInterface
import com.lions.bluestudio.databinding.ActivityMovieBinding
import com.lions.bluestudio.ui.adapters.MovieAdapterNow
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movie.*
import kotlinx.android.synthetic.main.activity_movie.rv_movies_list
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityMovie : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding
    //private lateinit var moviescopy: List<Movie>
    private lateinit var moviescopy: List<Movie>
    private lateinit var moviesres: MutableList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rv_movies_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_movies_list.setHasFixedSize(true)
        getMovieData {movies : List<Movie> ->
            moviescopy = movies
            rv_movies_list.adapter = MovieAdapter(movies)
        }

       rv_movies_list2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_movies_list2.setHasFixedSize(true)
        getMovieNowData { moviesnow : List<NowMovies> ->

            rv_movies_list2.adapter = MovieAdapterNow(moviesnow)
        }

        binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               binding.searchview.clearFocus()

                if(query!=null){
                    searchOnRecycler(query)
                }
                return true
            }

            override fun onQueryTextChange(query2: String?): Boolean {
                if(query2!=null){
                    searchOnRecycler(query2)
                }
                return true
            }
        })

    }

    private fun searchOnRecycler(query: String?): Boolean {
        for(item in moviescopy){
            if(item.title?.contains(query.toString())!!){
                Toast.makeText(this, "Item = "+ item.title.toString(), Toast.LENGTH_LONG ).show()
                //moviesres.add(item)
            }

            if(moviescopy.isEmpty()){
                Toast.makeText(this, "No hay datos para mostrar!", Toast.LENGTH_LONG ).show()
            }else{
                Toast.makeText(this, "Si hubo datos para llenar RecyclerView!", Toast.LENGTH_LONG ).show()
            }
        }
        return true
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }
        })
    }

    private fun getMovieNowData(callback: (List<NowMovies>) -> Unit){
        val apiService = MovieApiServiceNow.getInstance().create(NowMovieInterface::class.java)
        apiService.getNowMovieList().enqueue(object : Callback<NowMoviesResponse> {
            override fun onFailure(call: Call<NowMoviesResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<NowMoviesResponse>,response: Response<NowMoviesResponse>) {
                return callback(response.body()!!.nowresults)
            }
        })
    }
}