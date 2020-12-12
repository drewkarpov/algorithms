package eleven

import com.google.gson.JsonObject

data class Magazine(
    var bullets: Int = 15
)

class OutOfMagazinesException(string: String) : Exception()

class Pistol {

    private var magazine = Magazine()
    private lateinit var oldMagazine: Magazine
    private var magazineCount = 5


    fun shot() {
        if (magazine.bullets == 0) {
            reload()
            println("перезарядили магазин")
        }
        magazine.bullets -= 1
        println("сделали выстрел")
    }

    fun reload() {
        if (magazineCount > 0) {
            oldMagazine = Magazine(magazine.bullets)
            magazine = Magazine()
            magazineCount -= 1
        } else {
            throw OutOfMagazinesException("нету новых магазинов с патронами")
        }
    }

    fun amount() {
        val jsonPistolParams = JsonObject()
        jsonPistolParams.addProperty("magazines", magazineCount)
        jsonPistolParams.addProperty("bullets", magazine.bullets)
        println(jsonPistolParams.toString())
    }


}

fun main(){
    val pistol = Pistol()

    for (i in 12..20) pistol.shot()
    pistol.reload()
    pistol.amount()
}