package model.people

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.swing.text.DateFormatter

class Employee(
    firstName: String,
    lastName: String,
    email: String,
    phoneNumber: String,
    val salary: Double,
    val socialSecurityNumber: String,
    val hireDate: String
) : Person(firstName = firstName, lastName = lastName, email = email, phoneNumber = phoneNumber) {

    override fun toString(): String {
        return "" // TODO format the data in any way you want! :]
    }

    /**
     * Prints a time of clocking in, in a nice format.
     *
     * Hint: to get time, you can create a `Date` object. Use SimpleDateFormatter to format the time!
     * */
    fun clockIn(): String {
        val currentDate = Date()
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return formatter.format(currentDate)
    }

    // TODO same as above, but times for clocking out!
    fun clockOut(): String? {
        val currentDate = Date()
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return formatter.format(currentDate)
    }
}