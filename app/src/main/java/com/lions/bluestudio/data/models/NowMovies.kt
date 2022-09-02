package com.lions.bluestudio.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NowMovies(
    @SerializedName("id")
    val id : String ?,

    @SerializedName("title")
    val title : String?,

    @SerializedName("release_date")
    val release : String?,

    @SerializedName("poster_path")
    val poster : String?

    ) : Parcelable {
    constructor() : this( "", "", "", "")
}