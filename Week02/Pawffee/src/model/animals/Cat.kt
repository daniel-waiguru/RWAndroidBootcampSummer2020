package model.animals

//class Cat(private val name: String,
//          private val breed: String,
//          private val sex: String,
//          private val shelterID: Int,
//          private val catID: Int,
//          private val sponsorship: MutableList<String>) {
//    fun adopt(catID: Int){}
//    fun sponsor(customerID: Int){}
//}
import model.caffe.Sponsorship
import java.util.*

data class Cat(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val gender: String,
    val shelterId: String,
    val sponsorships: MutableSet<Sponsorship> = mutableSetOf()
)