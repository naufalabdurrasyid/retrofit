package com.example.retrofitcoba.retrofit

import com.example.retrofitcoba.model.ProvinsiModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Streaming

interface ProvinsiInterface {
    @Streaming
    @GET("api/daerahindonesia/provinsi")
    fun getNamaProvinsi(): Call<ProvinsiModel>
}