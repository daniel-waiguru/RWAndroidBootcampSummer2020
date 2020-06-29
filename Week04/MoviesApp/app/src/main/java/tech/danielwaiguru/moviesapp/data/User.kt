package tech.danielwaiguru.moviesapp.data

import java.util.*

data class User(
    val isLoggedin: Boolean = false,
    val id: String = UUID.randomUUID().toString()
)