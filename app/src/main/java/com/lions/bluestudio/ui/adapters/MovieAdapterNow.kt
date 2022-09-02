package com.lions.bluestudio.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lions.bluestudio.R
import com.lions.bluestudio.data.models.Movie
import com.lions.bluestudio.data.models.NowMovies
import com.lions.bluestudio.ui.MovieAdapter
import kotlinx.android.synthetic.main.top_movies.view.*

class MovieAdapterNow (
    private val movies : List<NowMovies>
) : RecyclerView.Adapter<MovieAdapterNow.MovieViewHolder>(){

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie : NowMovies){
            itemView.txt_title.text = movie.title
            itemView.txt_average.text = movie.release.toString()
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.img_auto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.now_movies, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }
}