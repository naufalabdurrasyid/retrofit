package com.example.retrofitcoba.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProvinsiClient {
    private var BASE_URL:String="https://dev.farizdotid.com/"
    private var retrofit: Retrofit? = null
    val getListNamaProvinsi: ProvinsiInterface
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit?.create(ProvinsiInterface::class.java)!!

        }
}