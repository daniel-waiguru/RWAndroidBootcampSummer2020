package model.caffe

import java.util.*

data class Product(
        val id: String = UUID.randomUUID().toString(),
        val productName: String,
        var price: Double
)