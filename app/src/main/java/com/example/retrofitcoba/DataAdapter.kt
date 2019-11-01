package com.example.retrofitcoba

import android.content.Context
import android.net.Uri
//import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitcoba.R
import com.example.retrofitcoba.model.DataModel
import com.example.retrofitcoba.model.ProvinsiModel
import com.squareup.picasso.Picasso

class DataAdpter(private var dataList: List<DataModel> , private val context: Context) : RecyclerView.Adapter<DataAdpter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_home, parent, false))

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel=dataList.get(position)

        holder.titleTextView.text=dataModel.title
        holder.url.text=dataModel.url

//        val path = dataModel.thumbnailurl
//
//        Glide.with(context)
//            .load(path)
//            .centerCrop()
//            .into(holder.thumbnailView)
        val path = dataModel.thumbnailurl

        Picasso.get()
            .load(path)
            .into(holder.thumbnailView)

    }

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var titleTextView:TextView = itemLayoutView.findViewById(R.id.title)
        var url:TextView = itemLayoutView.findViewById(R.id.url)
        var thumbnailView:ImageView = itemLayoutView.findViewById(R.id.thumbnail)


    }

}