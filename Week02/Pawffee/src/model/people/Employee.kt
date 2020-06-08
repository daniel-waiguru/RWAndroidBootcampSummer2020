package model.people

import java.text.SimpleDateFormat
import java.util.*

class Employee(
        firstName: String,
        lastName: String,
        email: String,
        phoneNumber: String,
        private val salary: Double,
        private val socialSecurityNumber: String,
        private val hireDate: String
) : Person(firstName = firstName, lastName = lastName, email = email, phoneNumber = phoneNumber) {

    override fun toString(): String {
        return """
            Name: $firstName $lastName
            email: $email
            Phone Number $phoneNumber
            Salary: $salary
            Social Security number: $socialSecurityNumber
            Date hired: $hireDate
        """.trimIndent() // TODO format the data in any way you want! :]
    }

    /**
     * Prints a time of clocking in, in a nice format.
     *
     * Hint: to get time, you can create a `Date` object. Use SimpleDateFormatter to format the time!
     * */
    fun clockIn(): String {
        val clockInDate = dateFormatter()
        return "$firstName $lastName clock in time is $clockInDate"
    }

    // TODO same as above, but times for clocking out!
    fun clockOut(): String {
        val clockOutDate = dateFormatter()
        return "$firstName $lastName clock in time is $clockOutDate"
    }
    private fun dateFormatter(): String {
        val currentDate = Date()
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return formatter.format(currentDate)
    }
}