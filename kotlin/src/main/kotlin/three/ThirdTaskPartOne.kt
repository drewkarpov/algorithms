package three

fun main() {
    val words = arrayOf("apple banana", "orange", "banana", "kiwi strawberry blueberry")
    var preparedWords = arrayOf<String>()

    for (word in words) {
        val preparedWord = cleanWordFromSpecificSymbolsAndNumbers(word).trim()
        val separatedWord = preparedWord.split(" ")
        if (separatedWord.size > 1) {
            separatedWord.forEach { preparedWords = preparedWords.plusElement(it) }
        } else {
            preparedWords = preparedWords.plusElement(word)
        }
    }
    println(preparedWords.contentToString())
}

private fun cleanWordFromSpecificSymbolsAndNumbers(word: String): String {
    val re = Regex("[^A-Za-z ]")
    return re.replace(word, "")
}