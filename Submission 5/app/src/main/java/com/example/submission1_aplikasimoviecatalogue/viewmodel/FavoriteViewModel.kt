package com.example.submission1_aplikasimoviecatalogue.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submission1_aplikasimoviecatalogue.database.MovieDatabase
import com.example.submission1_aplikasimoviecatalogue.model.Movie
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel() {

    var listFavorite  = MutableLiveData<List<Movie>>()

    fun initialFavorite(context: Context){
        val db = MovieDatabase(context)
        GlobalScope.launch {
            val movies = db.MovieDao().getAll()
            Log.d("MOVIE CATALOG ", movies.size.toString())
            listFavorite.postValue(movies)
        }
    }

    internal fun getFavorite(): LiveData<List<Movie>>{
        return listFavorite
    }
}