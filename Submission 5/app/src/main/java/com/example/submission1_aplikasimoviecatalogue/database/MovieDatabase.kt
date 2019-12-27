package com.example.submission1_aplikasimoviecatalogue.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.submission1_aplikasimoviecatalogue.dao.MovieDao
import com.example.submission1_aplikasimoviecatalogue.model.Movie

@Database(
    entities = [Movie::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase(){
    abstract fun MovieDao() : MovieDao

    companion object {
        @Volatile private var instance: MovieDatabase? = null
        private  var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context, MovieDatabase::class.java, "movie.db").build()

    }


}