package com.lions.bluestudio.data.services

import com.lions.bluestudio.data.models.NowMoviesResponse
import retrofit2.Call
import retrofit2.http.GET

interface NowMovieInterface {

    @GET("/3/movie/now_playing?api_key=5cedfec772080ac39918e6557563e04d")
    fun getNowMovieList(): Call<NowMoviesResponse>
}