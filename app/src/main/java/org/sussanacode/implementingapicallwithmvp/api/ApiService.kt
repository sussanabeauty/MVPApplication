package org.sussanacode.implementingapicallwithmvp.api


import org.sussanacode.implementingapicallwithmvp.model.ProductResponseData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("getProducts")
    fun getProducts(): Call<ProductResponseData>
}