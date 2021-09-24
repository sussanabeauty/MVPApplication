package org.sussanacode.implementingapicallwithmvp.presenter

import org.sussanacode.implementingapicallwithmvp.model.Product

interface ProductContract {

    interface IView{
        fun setResultData(products: ArrayList<Product>)
    }

    interface IPresenter{
        fun getProductData()
    }
}