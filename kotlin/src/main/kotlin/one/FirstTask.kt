package one

import java.net.ConnectException

fun main() {
    val username = "Andrey"
    sentGreetingsWithUsername(16, username)
    sentGreetingsWithCurrentTimesOfDayAndUsername(username)
}

fun sentGreetingsWithUsername(hour: Int, username: String) {
    var timesOfDay = ""
    when (hour) {
        in 0..4 -> {
            timesOfDay = "Доброй ночи,"
        }
        in 5..9 -> {
            timesOfDay = "Доброе утро,"
        }
        in 10..16 -> {
            timesOfDay = "Добрый день,"
        }
        in 17..23 -> {
            timesOfDay = "Добрый вечер,"
        }
        else -> {
            throw IllegalArgumentException("значение часа должно быть от 0 до 23 включительно")
        }
    }
    println("$timesOfDay $username")
}

fun sentGreetingsWithCurrentTimesOfDayAndUsername(username: String) {
    val responseFromTimezoneAPI = khttp.get(url = "https://timezoneapi.io/api/ip/?token=nDHCebPWNumL")
    if (responseFromTimezoneAPI.statusCode == 200) {
        val hours = responseFromTimezoneAPI.jsonObject
            .getJSONObject("data").getJSONObject("datetime").getInt("hour_24_wolz")
        sentGreetingsWithUsername(hour = hours, username = username)
    } else {
        throw ConnectException("некорректный ответ от сервера, код ответа: ${responseFromTimezoneAPI.statusCode}")
    }
}