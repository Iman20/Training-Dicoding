package com.example.submission1_aplikasimoviecatalogue.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission1_aplikasimoviecatalogue.DetailActivity
import com.example.submission1_aplikasimoviecatalogue.R
import com.example.submission1_aplikasimoviecatalogue.adapter.MovieAdapter
import com.example.submission1_aplikasimoviecatalogue.model.Movie
import com.example.submission1_aplikasimoviecatalogue.viewmodel.TVViewModel
import kotlinx.android.synthetic.main.tv_layout.*

class TvFragment : Fragment() {
    private lateinit var adapter: MovieAdapter
    private var tvs = arrayListOf<Movie>()
    private lateinit var tvViewModel: TVViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initData()
        initListener()
        return inflater.inflate(R.layout.tv_layout, container, false)
    }


    private fun showDialog(b: Boolean) {
        if(b){
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

    private fun initListener() {
        tvViewModel.getTv().observe(this, Observer {
            tv ->
            if (tv != null){
                tvs.addAll(tv)
                initRecycle()
                showDialog(false)
            }

        })
    }



    private fun initData() {
        tvViewModel  = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(TVViewModel::class.java)
        tvViewModel.initialTv()
    }

    private fun initRecycle() {
        tvRv.layoutManager = LinearLayoutManager(context)
        adapter = context?.let { MovieAdapter(tvs) }!!
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