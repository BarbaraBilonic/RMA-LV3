package barbarabilonic.ferit.zad2.persistence

import barbarabilonic.ferit.zad2.model.InspiringPearson
import kotlin.random.Random

object PeopleRepository {
    private val people= mutableListOf<InspiringPearson>(
        InspiringPearson(
            1,
            "Albert Einstein",
            "14 March 1879 – 18 April 1955",
            "Theoretical physicist, widely acknowledged to be one of the greatest physicists of all time.",
            "We cannot solve our problems with the same thinking we used when we created them.","Imagination is more important than knowledge.",
            "https://upload.wikimedia.org/wikipedia/commons/8/8f/Albert_Einstein_Head_%28cropped%29.jpg"
        ),

        InspiringPearson(
            2,
            "Nikola Tesla",
            "10 July 1856 – 7 January 1943",
            "Inventor, electrical engineer, mechanical engineer, and futurist best known for his contributions to the design of the modern alternating current (AC) electricity supply system.",
            "One must be sane to think clearly, but one can think deeply and be quite insane.","The present is theirs; the future, for which I really worked, is mine.",
            "https://upload.wikimedia.org/wikipedia/commons/7/79/Tesla_circa_1890.jpeg"
        )
    )

    fun getPeople() : List<InspiringPearson> =
        people




   

}