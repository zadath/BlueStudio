package com.lions.bluestudio.data.services

import com.lions.bluestudio.data.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=5cedfec772080ac39918e6557563e04d")
    fun getMovieList(): Call<MovieResponse>
}