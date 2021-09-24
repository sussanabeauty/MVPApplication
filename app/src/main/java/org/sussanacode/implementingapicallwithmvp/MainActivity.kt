package org.sussanacode.implementingapicallwithmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.sussanacode.implementingapicallwithmvp.databinding.ActivityMainBinding
import org.sussanacode.implementingapicallwithmvp.holderNadapter.ProductAdapter
import org.sussanacode.implementingapicallwithmvp.model.Product
import org.sussanacode.implementingapicallwithmvp.model.ProductResponseData
import org.sussanacode.implementingapicallwithmvp.presenter.ProductContract
import org.sussanacode.implementingapicallwithmvp.presenter.ProductPresenter
import org.sussanacode.implementingapicallwithmvp.stringkotlin.StringContract
import org.sussanacode.implementingapicallwithmvp.stringkotlin.StringPresenter

class MainActivity : AppCompatActivity(), ProductContract.IView, StringContract.IView {

    lateinit var binding: ActivityMainBinding
    lateinit var prodPresenter: ProductContract.IPresenter
    lateinit var strPresenter: StringPresenter

    lateinit var productAdapter: ProductAdapter
     var productList: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDisplayProduct.layoutManager = LinearLayoutManager(baseContext)
        prodPresenter = ProductPresenter(this)
        prodPresenter.getProductData()

        strPresenter = StringPresenter(this)
        strPresenter.getcharacterrepeat("Sussana Beauty")


    }

    override fun setResultData(products: ArrayList<Product>) {

        if (products != null) {
            productList.addAll(products)
        }

        productAdapter = ProductAdapter(productList)
        binding.rvDisplayProduct.adapter = productAdapter

       //binding.tvProductData.setText(products.toString())
    }

    override fun setResultData(str: String) {
        binding.tvchar.setText(str)
       // Log.d("String first repeating character", "$str")
    }
}