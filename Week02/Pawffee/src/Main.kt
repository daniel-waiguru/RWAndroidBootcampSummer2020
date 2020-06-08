import helper.CafeController

fun main() {

    val cafeController = CafeController() // print out the data here using CafeController functions
    println("Today's total number of adoption in each shelter: ${cafeController.getNumberOfAdoptionsPerShelter()}")
    println("Unadopted cats: ${cafeController.getUnadoptedCats()}" +
            "Unsponsored cats: ${cafeController}")
}