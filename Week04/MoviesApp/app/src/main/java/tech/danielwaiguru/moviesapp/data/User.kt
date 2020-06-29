package tech.danielwaiguru.moviesapp.data

import java.util.*

data class User(
    var isLoggedin: Boolean = false,
    val id: String = UUID.randomUUID().toString()
)