package org.sussanacode.implementingapicallwithmvp.presenter

import android.util.Log
import org.sussanacode.implementingapicallwithmvp.api.APIClient
import org.sussanacode.implementingapicallwithmvp.model.Product
import org.sussanacode.implementingapicallwithmvp.model.ProductResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductPresenter(val IView: ProductContract.IView): ProductContract.IPresenter {

    override fun getProductData() {

        val callbacklist = APIClient.apiService.getProducts()

        callbacklist.enqueue(object: Callback<ProductResponseData> {
            override fun onResponse(
                call: Call<ProductResponseData>,
                response: Response<ProductResponseData>
            ) {
                if(!response.isSuccessful){
                    Log.d("Product Response Failed" ,"Failed to retrieve data. Error: ${call.toString()}")
                }

                val data = response.body()

                IView.setResultData(response.body()?.products as ArrayList<Product>)
                //IView.setResultData(data)

            }

            override fun onFailure(call: Call<ProductResponseData>, t: Throwable) {
                t.printStackTrace()
                Log.d("Product Response Error" ,"error whiles retrieving data. Error: ${call.toString()}")

            }
        })



    }
}