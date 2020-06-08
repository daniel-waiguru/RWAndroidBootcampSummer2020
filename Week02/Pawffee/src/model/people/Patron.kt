package model.people

class Patron(
    firstName: String,
    lastName: String,
    email: String,
    phoneNumber: String
) : Person(firstName = firstName, lastName = lastName, email = email, phoneNumber = phoneNumber) {

    override fun toString(): String {
        return """
            Name: $firstName $lastName
            Email: $email
            Phone number: $phoneNumber
        """.trimIndent() // TODO format the data in any way you want! :]
    }


}