package com.example.retrofitcoba.retrofit
import com.example.retrofitcoba.model.DataModel

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Streaming

interface ApiInterface {
    @Streaming
    @GET("photos")
    fun getPhotos(): Call<List<DataModel>>

}