package com.example.retrofitcoba

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitcoba.model.DataModel
import com.example.retrofitcoba.model.ProvinsiModel
import com.example.retrofitcoba.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.R.layout.simple_list_item_1
import android.content.Intent
import com.example.retrofitcoba.retrofit.ProvinsiClient
import com.example.retrofitcoba.retrofit.ProvinsiClient.getListNamaProvinsi


class MainActivity : AppCompatActivity() {

    lateinit var progerssProgressDialog: ProgressDialog
    var dataList = ArrayList<DataModel>()
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        //setting up the adapter
        recyclerView.adapter= DataAdpter(dataList,this)
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)


//        val provinsi = ProvinsiModel.nama
//
//        namaProvinsi.adapter = ArrayAdapter(this, simple_list_item_1, provinsi)


        progerssProgressDialog=ProgressDialog(this)
        progerssProgressDialog.setTitle("Loading")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()
        getDat1a()
        btnNext.setOnClickListener {
            val i: Intent = Intent(this, TesActivity::class.java)
            this.startActivity(i)
            finish()
        }

    }

    private fun getDat1a() {
        val call: Call<List<DataModel>> = ApiClient.getClient.getPhotos()
        call.enqueue(object : Callback<List<DataModel>> {

            override fun onResponse(call: Call<List<DataModel>>?, response: Response<List<DataModel>>?) {
                progerssProgressDialog.dismiss()
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter!!.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                progerssProgressDialog.dismiss()
            }

        })
    }


}
