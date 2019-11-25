package com.example.submission1_aplikasimoviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submission1_aplikasimoviecatalogue.adapter.MovieAdapter
import com.example.submission1_aplikasimoviecatalogue.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: MovieAdapter
    private lateinit var listTitle : Array<String>
    private lateinit var listSubtitle : Array<String>
    private lateinit var listDirector : Array<String>
    private lateinit var listWriter : Array<String>
    private lateinit var listScreenPlay : Array<String>
    private lateinit var listImage : TypedArray
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
        addDataToList()
    }

    private fun addDataToList() {
        for (position in listTitle.indices){
            val movie = Movie(
                listImage.getResourceId(position, -1),
                listTitle[position],
                listSubtitle[position],
                listDirector[position],
                listWriter[position],
                listScreenPlay[position]
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }

    private fun initData() {
        listTitle = resources.getStringArray(R.array.list_title_movie)
        listSubtitle = resources.getStringArray(R.array.list_description_movie)
        listDirector = resources.getStringArray(R.array.list_director_1)
        listWriter = resources.getStringArray(R.array.list_director_2)
        listScreenPlay = resources.getStringArray(R.array.list_screen_play)
        listImage = resources.obtainTypedArray(R.array.list_images_movie)
    }

    private fun initView() {
        adapter = MovieAdapter(this)
        listView.adapter = adapter
        adapter.setOnClickListener(object : MovieAdapter.OnItemClickListener{
            override fun OnItemClicked(movie: Movie) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.DATA, movie)
                startActivity(intent)
            }
        })
    }
}
