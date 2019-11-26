package com.example.submission1_aplikasimoviecatalogue.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    var image: Int,
    var title: String,
    var description: String,
    var director: String,
    var writer: String,
    var screenPlay: String
) : Parcelable