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
    val employee = Employee("Daniel", "Waiguru", "danielirungu91@gmail.com", "23333", 22456.00, "23D4RT", "12-06-2020")

    // maybe as employees check in, you can add them to the list of working employees!
    private val employees = mutableSetOf<Employee>()
    private val customers = mutableSetOf<Person>()

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