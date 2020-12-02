package three

import com.google.gson.JsonObject

fun main() {
    val text = "Ну что ж я, я найти решения правильного не смогу ж? Смогу ж конечно, я ж старательный все ж таки."
    val maxCount = 3
    val separatedTextWithoutSymbols = cleanTextFromSpecificSymbolsAndNumbers(text).split(" ")
    val wordsMap = mapTextWordsToMap(separatedTextWithoutSymbols, maxCount)

    println(mapWordsMapToJsonObject(wordsMap))
}


private fun cleanTextFromSpecificSymbolsAndNumbers(text: String): String {
    val re = Regex("[^A-Za-zА-Яа-я ]")
    return re.replace(text, "")
}

private fun mapTextWordsToMap(separatedText: List<String>, maxCount: Int): MutableMap<String, Int> {
    val wordsMap = mutableMapOf<String, Int>()
    separatedText.forEach {
        if (wordsMap.containsKey(it)) {
            wordsMap[it.toLowerCase()] = wordsMap[it.toLowerCase()]!!.toInt() + 1
        } else {
            wordsMap[it.toLowerCase()] = 1
        }
    }

    return wordsMap.filter { it.value >= maxCount }.toMutableMap()
}

private fun mapWordsMapToJsonObject(wordsMap: MutableMap<String, Int>): JsonObject {
    val wordsJson = JsonObject()
    wordsMap.forEach {
        wordsJson.addProperty(it.key, it.value)
    }
    return wordsJson
}