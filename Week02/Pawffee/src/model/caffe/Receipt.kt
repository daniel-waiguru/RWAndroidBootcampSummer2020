package model.caffe

import java.util.*

// TODO add data, such as ID, list of products, and maybe an optional set of cats adopted/sponsored!
class Receipt(
        val receiptID: String = UUID.randomUUID().toString(),
        private val items: MutableList<Product>
) {
//    private var total: Double = 0.0
//        get() = computeAmount()
//    private fun computeAmount(): Double {
//        val prices = items.map { item ->
//            item.price
//
//        }
//        prices.forEach{ price ->
//            total += price
//        }
//        return total
//    }

}