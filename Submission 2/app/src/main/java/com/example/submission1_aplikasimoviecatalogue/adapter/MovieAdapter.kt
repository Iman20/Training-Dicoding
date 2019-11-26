package com.example.submission1_aplikasimoviecatalogue.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.submission1_aplikasimoviecatalogue.R
import com.example.submission1_aplikasimoviecatalogue.model.Movie

class MovieAdapter internal constructor(private val movies: ArrayList<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>(){

    private lateinit var onItemClickListener : OnItemClickListener

    interface OnItemClickListener{
        fun OnItemClicked(movie: Movie)
    }

    fun setOnClickListener(onclick : OnItemClickListener){
        this.onItemClickListener = onclick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_row_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }


    inner class ViewHolder internal constructor(view: View): RecyclerView.ViewHolder(view){
        private val textTitle : TextView = view.findViewById(R.id.textTitle)
        private val textSubTitle : TextView = view.findViewById(R.id.textSubTitle)
        private val image : ImageView = view.findViewById(R.id.imageView)
        private val container : LinearLayout = view.findViewById(R.id.containerView)

        internal fun bind(movie: Movie){
            textTitle.text = movie.title
            textSubTitle.text = movie.description
            image.setImageResource(movie.image)
            container.setOnClickListener {
                onItemClickListener.OnItemClicked(movie)
            }
        }
    }
}