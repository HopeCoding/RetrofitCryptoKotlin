package com.hopecoding.retrofitkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hopecoding.retrofitkotlin.adapter.RecyclerViewAdapter
import com.hopecoding.retrofitkotlin.databinding.ActivityMainBinding
import com.hopecoding.retrofitkotlin.model.CryptoModel
import com.hopecoding.retrofitkotlin.service.CryptoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.Listener {

    private val Base_URL = "https://rest.coinapi.io/v1/"
    private var cryptoModels: ArrayList<CryptoModel>? = null
    private var recyclerViewAdapter: RecyclerViewAdapter? = null

    private lateinit var binding: ActivityMainBinding

    //Disposable kullan at

    private var compositeDisposable: CompositeDisposable? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //3A9EFB1E-6C42-465A-9F53-8FA776750846


        compositeDisposable = CompositeDisposable()

        //RecylerView
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager


        loadData()


    }




    private fun loadData() {
        //Retrofitin içine RxJava kullanacağımızı belirttik.
        //Farklı farklı istekleri compositeDisposable.add şeklinde ekleyebiliyoruz.
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(CryptoAPI::class.java)

        compositeDisposable?.add(
            retrofit.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse,{
                    it.printStackTrace()
                })
        )

        /*

        val service = retrofit.create(CryptoAPI::class.java)

        val call = service.getData()


        call.enqueue(object : Callback<List<CryptoModel>> {
            override fun onResponse(
                call: Call<List<CryptoModel>>,
                response: Response<List<CryptoModel>>,
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        cryptoModels = ArrayList(it)

                        cryptoModels?.let {
                            recyclerViewAdapter = RecyclerViewAdapter(it,this@MainActivity)
                            binding.recyclerView.adapter = recyclerViewAdapter
                        }

                    }
                }
            }

            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })  */


    }


    override fun onItemClick(cryptoModel: CryptoModel) {
        Toast.makeText(this, "Clicked :${cryptoModel.name}", Toast.LENGTH_SHORT).show()
    }

    private fun handleResponse(cryptoList: List<CryptoModel>) {
        Log.d("Main Activity", "Received data: $cryptoList")
        cryptoModels = ArrayList(cryptoList)

        cryptoModels?.let {
            recyclerViewAdapter = RecyclerViewAdapter(it, this@MainActivity)
            binding.recyclerView.adapter = recyclerViewAdapter
        }


    }



    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable?.clear()

    }

}