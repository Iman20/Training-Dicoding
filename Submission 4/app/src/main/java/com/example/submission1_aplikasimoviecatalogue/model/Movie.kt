package com.example.submission1_aplikasimoviecatalogue.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    var image: Int = 0,
    var title: String? = null,
    var description: String? = null,
    var director: String? = null,
    var writer: String? = null,
    var screenPlay: String? = null,
    var rate: String? = null,
    var releaseDate: String? = null,
    var voteCount: String? = null,
    var voteAvarage: String? = null,
    var popularity: String? = null,
    var posterPath: String? = null,
    var backdropPath: String? = null
) : Parcelable