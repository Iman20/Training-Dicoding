package com.example.submission1_aplikasimoviecatalogue.fragment

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission1_aplikasimoviecatalogue.DetailActivity
import com.example.submission1_aplikasimoviecatalogue.R
import com.example.submission1_aplikasimoviecatalogue.adapter.MovieAdapter
import com.example.submission1_aplikasimoviecatalogue.model.Movie
import kotlinx.android.synthetic.main.tv_layout.*

class TvFragment : Fragment() {
    private lateinit var adapter: MovieAdapter
    private lateinit var listTitle : Array<String>
    private lateinit var listSubtitle : Array<String>
    private lateinit var listDirector : Array<String>
    private lateinit var listWriter : Array<String>
    private lateinit var listScreenPlay : Array<String>
    private lateinit var listImage : TypedArray
    private var movies = arrayListOf<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tv_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        addDataToList()
        initView()

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
    }

    private fun initData() {
        listTitle = resources.getStringArray(R.array.list_title_tv)
        listSubtitle = resources.getStringArray(R.array.list_description_tv)
        listDirector = resources.getStringArray(R.array.list_director_1_tv)
        listWriter = resources.getStringArray(R.array.list_director_2_tv)
        listScreenPlay = resources.getStringArray(R.array.list_screen_play_tv)
        listImage = resources.obtainTypedArray(R.array.list_images_tv)
    }

    private fun initView() {
        tvRv.layoutManager = LinearLayoutManager(context)
        adapter = context?.let { MovieAdapter(movies) }!!
        tvRv.adapter = adapter
        adapter.setOnClickListener(object : MovieAdapter.OnItemClickListener{
            override fun OnItemClicked(movie: Movie) {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.DATA, movie)
                startActivity(intent)
            }
        })
    }
}