package com.example.submission1_aplikasimoviecatalogue.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission1_aplikasimoviecatalogue.model.Movie
import com.example.submission1_aplikasimoviecatalogue.repository.TvRepository

class TVViewModel(
    private val tvRepository: TvRepository
) : ViewModel() {

    fun getTv() : LiveData<List<Movie>>{
        return tvRepository.initialTv()
    }
}