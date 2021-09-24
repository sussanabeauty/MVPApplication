package org.sussanacode.implementingapicallwithmvp.holderNadapter

import androidx.recyclerview.widget.RecyclerView
import org.sussanacode.implementingapicallwithmvp.databinding.HolderProductBinding
import org.sussanacode.implementingapicallwithmvp.model.Product
import org.sussanacode.implementingapicallwithmvp.model.ProductResponseData


class ProductHolder (val binding: HolderProductBinding): RecyclerView.ViewHolder(binding.root){

   fun productBind(product: Product){
      binding.tvproductid.text = "Product_id: ${product.product_id}"
       binding.tvproductname.text = "name: ${product.name}"
       binding.tvproductdesc.text = "description: ${product.description}"
       binding.tvproductcategory.text = "category: ${product.category}"
       binding.tvproductprice.text = "price: ${product.price}"
   }
}