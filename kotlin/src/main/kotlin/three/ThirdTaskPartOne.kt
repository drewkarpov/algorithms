package three

fun main() {
    val words = arrayOf("apple banana", "orange", "banana", "kiwi strawberry blueberry")
    var clearWords = arrayOf<String>()

    for (word in words) {
        val preparedWord = cleanWordFromSpecificSymbolsAndNumbers(word).trim()
        val separatedWord = preparedWord.split(" ")
        if (separatedWord.size > 1) {
            separatedWord.forEach { clearWords = clearWords.plusElement(it) }
        } else {
            clearWords = clearWords.plusElement(word)
        }
    }
    println(clearWords.contentToString())
}

private fun cleanWordFromSpecificSymbolsAndNumbers(word: String): String {
    val re = Regex("[^A-Za-z ]")
    return re.replace(word, "")
}