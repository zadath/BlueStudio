package com.lions.bluestudio.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NowMoviesResponse(
    @SerializedName("results")
    val nowresults : List<NowMovies>

) : Parcelable {
    constructor() : this(mutableListOf())
}