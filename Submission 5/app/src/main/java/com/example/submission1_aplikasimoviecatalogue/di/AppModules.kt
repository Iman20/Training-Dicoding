package com.example.submission1_aplikasimoviecatalogue.di

import androidx.room.Room
import com.androidnetworking.AndroidNetworking
import com.example.submission1_aplikasimoviecatalogue.BuildConfig
import com.example.submission1_aplikasimoviecatalogue.dao.MovieDao
import com.example.submission1_aplikasimoviecatalogue.database.MovieDatabase
import com.example.submission1_aplikasimoviecatalogue.repository.TvRepository
import com.example.submission1_aplikasimoviecatalogue.viewmodel.TVViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

val appModule = module {

    single { MovieDatabase.getInstance(androidContext()) }
    single { get<MovieDatabase>().movieDao() }
    single { AndroidNetworking.get("\"https://api.themoviedb.org/3/discover/tv?api_key=${BuildConfig.API_KEY}&language=en-US\"").build() }

}

val repositoryModule = module {
    factory { TvRepository(get(), get()) }
}

val viewModule = module {
    viewModel { TVViewModel(get()) }
}

val allModule = listOf(appModule, viewModule, repositoryModule)

