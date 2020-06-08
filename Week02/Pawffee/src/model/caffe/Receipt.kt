package model.caffe

import model.animals.Cat
import java.util.*

// TODO add data, such as ID, list of products, and maybe an optional set of cats adopted/sponsored!
class Receipt(
        val receiptID: String = UUID.randomUUID().toString(),
        val customerId: String,
        private val products: MutableList<Product> = mutableListOf(),
        val adoptedCats: MutableSet<Cat> = mutableSetOf()
) {
    private var total: Double = 0.0
        get() = computeAmount()
    private fun computeAmount(): Double {
        val prices = products.map { product ->
            product.price

        }
        prices.forEach{ price ->
            total += price
        }
        return total
    }

}