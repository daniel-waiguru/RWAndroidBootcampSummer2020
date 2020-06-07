package model.shelter

import model.animals.Cat
import java.util.*

// TODO add remaining data
data class Shelter(val shelterID:String = UUID.randomUUID().toString(),
                   val name: String,
                   val address: String,
                   val shelterPhone: String,
                   val cats: MutableSet<Cat>,
                   val catsAdopted: MutableSet<Cat>
)