package com.example.retrofitcoba

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.example.retrofitcoba.model.ProvinsiModel
import com.example.retrofitcoba.ProvinsiAdapter
import com.example.retrofitcoba.SpinnerActivity
import com.example.retrofitcoba.R
import com.example.retrofitcoba.retrofit.ProvinsiClient

import com.example.retrofitcoba.retrofit.ProvinsiInterface
import org.junit.experimental.results.ResultMatchers.isSuccessful
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TesActivity : AppCompatActivity() {

    @BindView(R.id.spinnerProvinsi)
    internal var spinnerProvinsi: Spinner? = null
    @BindView(R.id.inputNama)
    internal var inputNama: EditText? = null
    @BindView(R.id.btnSimpan)
    internal var btnSimpan: Button? = null
    internal var loading = ProgressBar

    internal var mContext= this
    internal var mApiService= ProvinsiClient.getListNamaProvinsi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tes_layout)

        ButterKnife.bind(this)
        mContext = this
        mApiService = ProvinsiClient.getListNamaProvinsi

        initspinnerProvinsi()

        spinnerProvinsi!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedName = parent.getItemAtPosition(position).toString()
                //                requestDetailDosen(selectedName);
                Toast.makeText(mContext, "Kamu memilih provinsi $selectedName", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    private fun initspinnerProvinsi() {
        loading = ProgressBar(mContext, null, android.R.attr.progressBarStyleLarge)

        mApiService.getNamaProvinsi().enqueue(object : Callback<ProvinsiModel> {
           override fun onResponse(call: Call<ProvinsiModel>, response: Response<ProvinsiModel>) {
                if (response.isSuccessful()) {
                    loading.dismiss()
                    val semuaProvinsiItems = response.body()!!.semuaprovinsi
                    val listSpinner = ArrayList<String>()
                    for (i in semuaProvinsiItems.indices) {
                        listSpinner.add(semuaProvinsiItems.get(i).nama)
                    }

                    val adapter = ArrayAdapter(
                        mContext,
                        android.R.layout.simple_spinner_item, listSpinner
                    )
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinnerProvinsi!!.adapter = adapter
                } else {
                    loading.dismiss()
                    Toast.makeText(mContext, "Gagal mengambil data dosen", Toast.LENGTH_SHORT)
                        .show()
                }
            }

           override fun onFailure(call: Call<ProvinsiModel>, t: Throwable) {
                loading.dismiss()
                Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
//
//import android.app.ProgressDialog
//import android.os.Bundle
//import android.os.PersistableBundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.retrofitcoba.model.DataModel
//import com.example.retrofitcoba.model.ProvinsiModel
//import com.example.retrofitcoba.model.SemuaProvinsi
//import com.example.retrofitcoba.retrofit.ApiClient
//import com.example.retrofitcoba.retrofit.ProvinsiClient
//import kotlinx.android.synthetic.main.tes_layout.*
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.http.Body
//
//class TesActivity : AppCompatActivity() {
//    lateinit var progerssProgressDialog: ProgressDialog
//    lateinit var provinsiList : List<SemuaProvinsi>
//    lateinit var recyclerViewutama: RecyclerView
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.tes_layout)
//        progerssProgressDialog = ProgressDialog(this@TesActivity)
//        progerssProgressDialog.setTitle("Loading")
//        progerssProgressDialog.setCancelable(false)
//        progerssProgressDialog.show()
//        getProvinsi()
//
//    }
//
//    private fun getProvinsi() {
//        val call: Call<ProvinsiModel> = ProvinsiClient.getListNamaProvinsi.getNamaProvinsi()
//        call.enqueue(object : Callback<ProvinsiModel> {
//            override fun onResponse(call: Call<ProvinsiModel>, response: Response<ProvinsiModel>) {
//                provinsiList = response.body()!!.semuaprovinsi
//                recyclerViewutama = findViewById(R.id.recycler_viewpertama)
//                //setting up the adapter
//                recyclerViewutama.adapter = ProvinsiAdapter(provinsiList, this@TesActivity)
//                recyclerViewutama.layoutManager =
//                    LinearLayoutManager(this@TesActivity, LinearLayoutManager.VERTICAL, false)
//
//                progerssProgressDialog.dismiss()
////        val provinsi = ProvinsiModel.nama
////
////        namaProvinsi.adapter = ArrayAdapter(this, simple_list_item_1, provinsi)
//            }
//
//            override fun onFailure(call: Call<ProvinsiModel>, t: Throwable) {
//                progerssProgressDialog.dismiss()
//            }
//        })
//    }
//}