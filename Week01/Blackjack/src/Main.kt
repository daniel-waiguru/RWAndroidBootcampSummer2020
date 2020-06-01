import kotlin.random.Random

fun main(args: Array<String>) {
    fun createDeck(): MutableSet<Card>{
        //Collection of Pips
        val pips = arrayOf("K", "Q", "J", "A", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1")
        //Collection of Suits
        val suits = arrayOf('C', 'D', 'H', 'S')
        var deckOfCards = mutableSetOf<Card>()
        suits.forEach { suit ->
            pips.forEach { pip ->
                val card = Card(pip, suit)
                deckOfCards.add(card)
            }
        }
        return deckOfCards

    }
    fun dealHand(numberOfCards:Int = 2, deck: MutableList<Card>): List<Card> {

        val cardsAtHand = mutableListOf<Card>()
        for (i in 0 until numberOfCards){
            val card = deck.random()
            cardsAtHand.add(card)
            deck.remove(card)
        }
        return cardsAtHand
    }

    fun evaluateHand(hand : List<Card>): Int {
        var total = 0
        for (card in hand){
            var pipValue = if (card.pip == "K" || card.pip == "Q" || card.pip == "J")
                10
            else if (card.pip == "A")
                11
            else card.pip.toInt()
            total += pipValue
        }
        return total
    }
    fun printResults(total: Int, hand :List<Card>){

        println("Your hand was:")
        println("""
            .-------.
            |${hand[0].pip}      |
            |     .-------.
            |  ${'\u2665'}  |${hand[1].pip}      |
            |     | |     |
            `.____|.'${'\u2663'}    |
                  |       |
                  |      ${hand[1].pip}|
                  `._____.'
        """.trimIndent())
        println("For a total of: $total")
        val message = if (total==21) "You Win!" else "You Lose"
        println(message)
    }
    val deckOfCards = createDeck()
    val cardsAtHand = dealHand(2,deckOfCards.toMutableList())
    val hand = evaluateHand(cardsAtHand)
    println(printResults(hand, cardsAtHand))
}