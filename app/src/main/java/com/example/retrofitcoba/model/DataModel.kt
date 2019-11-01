package com.example.retrofitcoba.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataModel (
    @Expose
    @SerializedName("albumId")
    val albumid: kotlin.Int,
    @Expose
    @SerializedName("id")
    val id: kotlin.Int,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("url")
    val url: String,
    @Expose
    @SerializedName("thumbnailUrl")
    val thumbnailurl: String
)