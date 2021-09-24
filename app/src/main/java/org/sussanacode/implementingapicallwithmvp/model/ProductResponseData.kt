package org.sussanacode.implementingapicallwithmvp.model

data class ProductResponseData(
    val status: Int,
    val message: String,
    val products: List<Product>
)


data class Product(
    val product_id: String,
    val name: String,
    val category: String,
    val description: String,
    val price: String
)