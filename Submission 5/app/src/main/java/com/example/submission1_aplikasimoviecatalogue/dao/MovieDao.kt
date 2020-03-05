package com.example.submission1_aplikasimoviecatalogue.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.submission1_aplikasimoviecatalogue.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = REPLACE)
    fun insertAll(vararg  movie: Movie)

    @Query("SELECT * FROM movie")
    fun getAll() : List<Movie>

    @Query("SELECT * FROM movie WHERE title LIKE :title")
    fun getByTitle(title: String): Movie

    @Update
    fun update(vararg movie: Movie)

    @Delete
    fun delete(movie: Movie)

}