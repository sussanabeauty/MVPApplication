package org.sussanacode.implementingapicallwithmvp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {

    lateinit var myRetrofit: Retrofit

    fun getRetrofit(): Retrofit {
        if(!this:: myRetrofit.isInitialized){
            myRetrofit = Retrofit.Builder()
                .baseUrl("https://psmobitech.com/fcmdemo/api/index.php/Product/")
                .addConverterFactory(GsonConverterFactory.create()).build()
        }

        return myRetrofit
    }

    val apiService: ApiService by lazy {
        getRetrofit().create(ApiService::class.java)
    }
}