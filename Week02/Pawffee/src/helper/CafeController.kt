package helper

import model.animals.Cat
import model.caffe.Cafe
import model.caffe.Product
import model.people.Person
import model.shelter.Shelter

class CafeController {

    // cafe related things
    private val cafe = Cafe()

    // shelter related things // TODO make sure to fill in the data!
    private val shelters = mutableSetOf<Shelter>(
            Shelter(shelterID = "242",name = "Nairobi shelter", address = "51-100 Nairobi", shelterPhone = "254 74567982",
                    cats = emptySet<Cat>() as MutableSet<Cat>,
                    catsAdopted = emptySet<Cat>() as MutableSet<Cat>),
            Shelter(shelterID = "249",name = "Diani shelter", address = "51-100 Mombasa", shelterPhone = "254 74567098",
                    cats = emptySet<Cat>() as MutableSet<Cat>,
                    catsAdopted = emptySet<Cat>() as MutableSet<Cat>)
    )
    private val shelterToCat = mutableMapOf<Shelter, MutableSet<Cat>>(
            shelters.elementAt(0) to mutableSetOf(
                    Cat("1", "Morris", "f", "242"),
                    Cat("6", "Orangey", "m", "242"),
                    Cat("4", "Lewis Carol", "f", "242"),
                    Cat("2", "Orangey", "m", "242")
            ),
            shelters.elementAt(1) to mutableSetOf(
                    Cat("8", "Orangey", "m", "242"),
                    Cat("5", "Lewis Carol", "f", "242"),
                    Cat("7", "CHOUPETTE", "f", "242"),
                    Cat("3", "CHOUPETTE", "m", "242")
            )
    )

    fun adoptCat(catId: String, person: Person) {

        // check if cats exist, and retrieve its entry!
        val catInShelter =
                shelterToCat.entries.firstOrNull { (_, catsInShelter) ->
            catsInShelter.any { it.id == catId }
        }

        // you can adopt that cat!
        if (catInShelter != null) {
            val cat = catInShelter.value.first { cat -> cat.id == catId } // find the cat for that ID again

            // remove the cat from the shelter
            catInShelter.value.remove(cat)

            // add the cat to the person
            person.cats.add(cat)
        }
    }

    fun sellItems(items: List<Product>, customerId: String) {

        /**
         * Also make sure to print receipt information out & add the receipt to the list of receipts for the current day.
         * You can random the day from a List, or check from the Date object!
         * */
        val receipt = cafe.getReceipt(items, customerId)

        println("$receipt")
    }

    /**
     * First gets a list of all adopters, then queries shelters.
     *
     * */
    fun getNumberOfAdoptionsPerShelter(): Map<String, Int> {
        val allAdopters = cafe.getAdopters()
        var retrievedAdopters = mutableMapOf<String, Int>()
        if (retrievedAdopters.isNotEmpty()){
            allAdopters.forEach { adopter->
                val allCatsAdopted = adopter.cats.size
                adopter.cats.forEach { cat->
                    val listOfShelters = shelters.filter { it.shelterID == cat.id }
                    retrievedAdopters = listOfShelters.map { it.name to allCatsAdopted }.toMap() as MutableMap<String, Int>
                }
            }
        }

        return retrievedAdopters // TODO find which cats belong to which shelter, and create a map of Shelter name to number of adoptions
    }

    fun getUnadoptedCats(): Set<Cat> {
        val unadoptedCats = mutableSetOf<Cat>()
        for (cats in shelterToCat){
            unadoptedCats.addAll(cats.value)
        }
        return unadoptedCats
    }
    fun receiptsForADay(day: String){
        return cafe.showNumberOfReceiptsForDay(day)
    }
    fun getSponsoredButUnadoptedCats(): MutableSet<Cat> {
        val sponsoredCatIds = cafe.getSponsoredCatsIds()
        val sponsoredCats = mutableSetOf<Cat>()
        shelterToCat.forEach {
            it.value.forEach() { cat ->
                if (cat.id in sponsoredCatIds) sponsoredCats.add(cat)}
        }
        return sponsoredCats
    }
    fun displayTotalCustomers(day: String){
        return cafe.totalNumberOfCustomers(day)
    }


    fun topTenItems(): Set<Product> {
        return cafe.getTopSellingItems()
    }
    fun popularCats(): Set<Cat> {
        return cafe.getMostPopularCats()
    }

}