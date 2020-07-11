package tech.danielwaiguru.estudy.models

import kotlinx.serialization.Serializable

@Serializable
data class Authors (
    val names: List<String>
)
