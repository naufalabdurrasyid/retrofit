package com.example.retrofitcoba

import android.content.Context
import android.net.Uri
//import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitcoba.R
import com.example.retrofitcoba.model.DataModel
import com.example.retrofitcoba.model.ProvinsiModel
import com.example.retrofitcoba.model.SemuaProvinsi
import com.squareup.picasso.Picasso

class ProvinsiAdapter(private var provinsiList: ArrayList<SemuaProvinsi> , private val context: Context) : RecyclerView.Adapter<ProvinsiAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_provinsi, parent, false))

    }

    override fun getItemCount(): Int {
        return provinsiList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val provinsiModel=provinsiList.get(position)

        holder.namanya.text=provinsiModel.nama

    }
    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var namanya:TextView = itemLayoutView.findViewById(R.id.spinnerProvinsi)




    }

}