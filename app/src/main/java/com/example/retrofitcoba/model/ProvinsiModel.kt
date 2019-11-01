package com.example.retrofitcoba.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//data class ProvinsiModel (
//        @Expose
//        @SerializedName("id")
//        val id: kotlin.Int,
//        @Expose ()
//        @SerializedName("nama")
//        val nama: String
//    )
data class ProvinsiModel (
    val error: String,
    var nama: String,
    var semuaprovinsi: List<SemuaProvinsi>
)

