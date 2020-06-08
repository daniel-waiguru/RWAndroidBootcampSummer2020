package model.caffe

import model.animals.Cat
import model.people.Employee
import model.people.Person
import java.time.LocalDate

class Cafe {


    // cafe related stuff

    /**
     * To simplify it, let's imitate a week-long cafe turnaround.
     *
     * Make sure to add your receipts to each set, with your data.
     * */
    private val receiptsByDay = mutableMapOf(
        "Monday" to mutableSetOf<Receipt>(),
        "Tuesday" to mutableSetOf<Receipt>(),
        "Wednesday" to mutableSetOf<Receipt>(),
        "Thursday" to mutableSetOf<Receipt>(),
        "Friday" to mutableSetOf<Receipt>(),
        "Saturday" to mutableSetOf<Receipt>(),
        "Sunday" to mutableSetOf<Receipt>()
    )
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

    // make sure to add sponsorships and tie them to people!
    private val sponsorships = mutableSetOf<Sponsorship>()

    // TODO Add logic for checking in and checking out!
    fun checkInEmployee(employee: Employee) {
        employee.clockIn()
        employees.add(employee)
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
        }
        return true
    }

    fun addSponsorship(catId: String, personId: String) {
        // TODO add the sponsorship
        sponsorships.add(Sponsorship(personId, catId))
    }

    fun getWorkingEmployees(): Set<Employee> = employees

    fun getAdoptedCats(): Set<Cat> {
        return emptySet()
    }

    fun getSponsoredCats(): Set<String> {
        val sponsoredCats = mutableSetOf<String>()
        for (sponsoredCat in sponsorships){
            sponsoredCats.add(sponsoredCat.catId)
        }
        return sponsoredCats
    }

    fun getMostPopularCats(): Set<Cat> {
        return emptySet()
    }

    fun getTopSellingItems(): Set<Product> {
        return emptySet()
    }

    fun getAdopters(): List<Person> {
        return (employees + customers).filter { it.cats.isNotEmpty() }
    }
}