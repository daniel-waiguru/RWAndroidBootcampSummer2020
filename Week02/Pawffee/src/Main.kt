import helper.CafeController
import model.caffe.Product
import java.time.LocalDate

fun main() {

    val today = LocalDate.now().dayOfWeek
    val cafeController = CafeController() // print out the data here using CafeController functions

    println("Total transactions ")
    cafeController.receiptsForADay(today.toString())

    println("Today's total number of adoption in each shelter: ${cafeController.getNumberOfAdoptionsPerShelter()}")

    println("Un adopted cats: ${cafeController.getUnadoptedCats()}" +
            "Un sponsored cats: ${cafeController.getSponsoredButUnadoptedCats()}")

    println("Total umber of customers and non-employee customers respectively")
    cafeController.displayTotalCustomers(today.toString())

    println("Total number of adoptions per shelter ${cafeController.getNumberOfAdoptionsPerShelter()}")

    println("Sponsored cats ${cafeController.getSponsoredButUnadoptedCats()}")

    println("Top selling menu ${cafeController.topTenItems()}")

    println("Most popular cats ${cafeController.popularCats()}")
    
    cafeController.sellItems(listOf(Product("7", "Cappuccino", 9.50)), "3")
}