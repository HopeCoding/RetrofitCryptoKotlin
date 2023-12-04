package com.hopecoding.retrofitkotlin.service


import com.hopecoding.retrofitkotlin.model.CryptoModel
import io.reactivex.Observable
import retrofit2.http.GET


interface CryptoAPI {

    //GET, POST, UPDATE, DELETE

    @GET("assets/apikey-3A9EFB1E-6C42-465A-9F53-8FA776750846")
    fun getData(): Observable<List<CryptoModel>>


    //fun getData(): Call<List<CryptoModel>>

}