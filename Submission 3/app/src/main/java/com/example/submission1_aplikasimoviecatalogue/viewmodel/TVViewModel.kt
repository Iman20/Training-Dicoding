package com.example.submission1_aplikasimoviecatalogue.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.example.submission1_aplikasimoviecatalogue.model.Movie
import org.json.JSONObject

class TVViewModel : ViewModel() {
    companion object{
        private const val API_KEY = "---"
    }

    var listTv = MutableLiveData<ArrayList<Movie>>()

    fun initialTv(){
        val listItems = ArrayList<Movie>()
        val url = "https://api.themoviedb.org/3/discover/tv?api_key=$API_KEY&language=en-US"
        var posterPath = "https://image.tmdb.org/t/p/w185"

        AndroidNetworking.get(url)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener{
                override fun onResponse(response: JSONObject?) {
                    val list = response?.getJSONArray("results")

                    for (i in 0 until list!!.length()){
                        val movie = list!!.getJSONObject(i)
                        val movieItems = Movie()
                        movieItems.title = movie.getString("name")
                        movieItems.description = movie.getString("overview")
                        movieItems.posterPath = posterPath +  movie.getString("poster_path")
                        movieItems.backdropPath = posterPath +  movie.getString("backdrop_path")
                        movieItems.popularity = movie.getString("popularity")
                        movieItems.voteCount = movie.getString("vote_count")
                        movieItems.voteAvarage = movie.getString("vote_average")
                        listItems.add(movieItems)
                    }
                    listTv.postValue(listItems)

                }

                override fun onError(anError: ANError?) {
                    Log.d("RESPONSE ", anError.toString())

                }
            })


    }

    internal fun getTv() : LiveData<ArrayList<Movie>>{
        return listTv
    }
}