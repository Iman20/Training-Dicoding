package com.example.submission1_aplikasimoviecatalogue.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.submission1_aplikasimoviecatalogue.R
import com.example.submission1_aplikasimoviecatalogue.model.Movie

class MovieAdapter internal constructor(private val context : Context): BaseAdapter(){

    internal var movies = arrayListOf<Movie>()
    private lateinit var onItemClickListener : OnItemClickListener

    interface OnItemClickListener{
        fun OnItemClicked(movie: Movie)
    }

    fun setOnClickListener(onclick : OnItemClickListener){
        this.onItemClickListener = onclick
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var itemView = p1
        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.layout_row_movie, p2, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val movie = getItem(p0) as Movie
        viewHolder.bind(movie)
        return itemView
    }

    override fun getItem(p0: Int): Any = movies[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getCount(): Int = movies.size

    private inner class ViewHolder internal constructor(view: View){
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