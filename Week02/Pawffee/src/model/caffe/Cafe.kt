package model.caffe

import model.animals.Cat
import model.people.Employee
import model.people.Person
import java.time.LocalDate

class Cafe {


    // cafe related stuff
    // maybe as employees check in, you can add them to the list of working employees!
    private val employees = mutableSetOf<Employee>(
            Employee("1","Daniel", "Irungu", "danny@gmail.com", "254 70234765",
                    500.0, "23D5Q", "6/06/2020"),
            Employee("2","Dweng", "Johnson", "johnson@gmail.com", "254 710678921",
                    200.0, "56Y8K", "8/04/2020"),
            Employee("3","Cara", "Broom", "broomcara@gmail.com", "254 75678901",
                    250.0, "0kD5Y", "6/02/2020"),
            Employee("4","Rakesh", "Ren", "rakesh@gmail.com", "254 7654318",
                    455.0, "23D5Q", "26/01/2020")
    )
    private val customers = mutableSetOf<Person>(
            Person("5", "Eric", "Bockman", "254 76345431", "eric@yahoo.com"),
            Person("6", "Miles", "Finer", "254 76900871", "miles.finer@yahoo.com"),
            Person("7", "Pakistani", "Dennish", "254 70065421", "dennish@gmail.com"),
            Person("8", "Jaya", "rakesh", "254 765689641", "jaya@yahoo.com")
    )

    /**
     * To simplify it, let's imitate a week-long cafe turnaround.
     *
     * Make sure to add your receipts to each set, with your data.
     * */
    private val receiptsByDay = mutableMapOf(
        "Monday" to mutableSetOf<Receipt>(
                Receipt("1","5", mutableListOf(Product(productName = "Cappuccino",price = 2.20))),
                Receipt("2","6", mutableListOf(Product(productName = "Bagel",price = 9.50))),
                Receipt("3","7", mutableListOf(Product(productName = "Cappuccino",price = 2.20))),
                Receipt("4","8", mutableListOf(Product(productName = "Bagel",price = 9.50)))
        ),
        "Tuesday" to mutableSetOf<Receipt>(
                Receipt("5","5", mutableListOf(Product(productName = "Bagel",price = 9.50))),
                Receipt("6","6", mutableListOf(Product(productName = "Cappuccino",price = 2.20))),
                Receipt("7","7", mutableListOf(Product(productName = "Bagel",price = 9.50))),
                Receipt("8","8", mutableListOf(Product(productName = "Bagel",price = 9.50)))
        ),
        "Wednesday" to mutableSetOf<Receipt>(
                Receipt("9","5", mutableListOf(Product(productName = "Bagel",price = 9.50))),
                Receipt("10","6", mutableListOf(Product(productName = "Cappuccino",price = 2.20))),
                Receipt("11","7", mutableListOf(Product(productName = "Bagel",price = 9.50))),
                Receipt("12","8", mutableListOf(Product(productName = "Bagel",price = 9.50)))
        ),
        "Thursday" to mutableSetOf<Receipt>(
                Receipt("13","5", mutableListOf(Product(productName = "Bagel",price = 9.50))),
                Receipt("14","6", mutableListOf(Product(productName = "Cappuccino",price = 2.20))),
                Receipt("15","7", mutableListOf(Product(productName = "Bagel",price = 9.50))),
                Receipt("16","8", mutableListOf(Product(productName = "Bagel",price = 9.50)))
        ),
        "Friday" to mutableSetOf<Receipt>(
                Receipt("17","5", mutableListOf(Product(productName = "Bagel",price = 9.50))),
                Receipt("18","6", mutableListOf(Product(productName = "Cappuccino",price = 2.20))),
                Receipt("19","7", mutableListOf(Product(productName = "Bagel",price = 9.50))),
                Receipt("20","8", mutableListOf(Product(productName = "Bagel",price = 9.50)))
        ),
        "Saturday" to mutableSetOf<Receipt>(
                Receipt("21","5", mutableListOf(Product(productName = "Bagel",price = 9.50))),
                Receipt("22","6", mutableListOf(Product(productName = "Cappuccino",price = 2.20))),
                Receipt("23","7", mutableListOf(Product(productName = "Bagel",price = 9.50))),
                Receipt("24","8", mutableListOf(Product(productName = "Bagel",price = 9.50)))
        ),
        "Sunday" to mutableSetOf<Receipt>(
                Receipt("25","5", mutableListOf(Product(productName = "Bagel",price = 9.50))),
                Receipt("26","6", mutableListOf(Product(productName = "Cappuccino",price = 2.20))),
                Receipt("27","7", mutableListOf(Product(productName = "Bagel",price = 9.50))),
                Receipt("28","8", mutableListOf(Product(productName = "Bagel",price = 9.50)))
        )
    )


    // make sure to add sponsorships and tie them to people!
    private val sponsorships = mutableSetOf<Sponsorship>(
            Sponsorship("1", "3"),
            Sponsorship("2", "3"),
            Sponsorship("3", "3"),
            Sponsorship("4", "1"),
            Sponsorship("5", "3"),
            Sponsorship("6", "2"),
            Sponsorship("7", "2"),
            Sponsorship("8", "2")
    )

    // TODO Add logic for checking in and checking out!
    fun checkInEmployee(employee: Employee) {
        employee.clockIn()
    }

    fun checkOutEmployee(employee: Employee) {
        employee.clockOut()
        employees.remove(employee.id)
    }

    fun showNumberOfReceiptsForDay(day: String) {
        val receiptForDay = receiptsByDay[day] ?: return // wrong day inserted!

        println("On $day you made ${receiptsByDay.size} transactions!")
    }

    fun getReceipt(items: List<Product>, customerId: String): Receipt {
        // TODO return a receipt! Also make sure to check if customer is also an employee
        items.forEach { product->
            if (isCustomerAnEmployee(product.id) && !product.productName.contains("Cat")){
                product.price *= 0.85
            }
            else
            {
                product.price
            }
        }
        val currentDay = LocalDate.now().dayOfWeek
        val receiptDetails = Receipt(customerId = customerId, products = items.toMutableList())
        receiptsByDay[currentDay]?.add(receiptDetails)
        return receiptDetails
    }
    private fun isCustomerAnEmployee(id: String): Boolean {
        employees.forEach { employeeId ->
            employeeId.id == id
            return true
        }
        return false
    }

    fun addSponsorship(catId: String, personId: String) {
        // TODO add the sponsorship
        sponsorships.add(Sponsorship(personId, catId))
    }

    fun getWorkingEmployees(): Set<Employee> = employees

    fun getAdoptedCats(): Set<Cat> {
        return setOf()
    }


    fun getSponsoredCatsIds(): Set<String> {
        val sponsoredCatIds = mutableSetOf<String>()
        sponsorships.forEach { sponsoredCatIds.addAll(listOf(it.catId)) }
        return sponsoredCatIds
    }

    fun getMostPopularCats(): Set<Cat> {
        return setOf()
    }

    fun getTopSellingItems(): Set<Product> {
        return setOf()
    }

    fun getAdopters(): List<Person> {
        return (employees + customers).filter { it.cats.isNotEmpty() }
    }
    fun totalNumberOfCustomers(day: String){
        val currentDayReceipt = receiptsByDay[day]?:return
        var customerEmployee = 0
        var customerPatron = 0
        currentDayReceipt.forEach {
            val customerId = it.customerId
            if (isCustomerAnEmployee(customerId)){
                customerEmployee++
            }
            customerPatron++
        }
        println("""Total customers for today: ${customerEmployee + customerPatron}
            Total non employees customers: $customerPatron
        """.trimMargin())

    }
}