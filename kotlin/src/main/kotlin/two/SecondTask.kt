package two

import com.google.gson.JsonObject

fun main() {
    val someText =
        "Клиентские библиотеки содержат готовый код, который разработчики могут использовать " +
                "в разработке ботов для решения различных задач. Благодаря библиотекам им не нужно " +
                "писать код с нуля, когда их проекты используют API."
    val textLength = 230
    val textWrapper = TextWrapper(
        originalText = someText,
        textLength = textLength,
        forbiddenWords = listOf("библиотеки", "ботов", "API")
    )

    textWrapper.apply {
        analyzeEnteredTextAndPrintResult()
        mapTextToJsonObjectAndPrintResult()
    }
}


// 2
data class Word(
    val value: String,
    val length: Int
)

class TextWrapper(val originalText: String, val textLength: Int, val forbiddenWords: List<String>) {

    init {
        if (originalText.length > textLength)
            throw IllegalArgumentException(
                "длина текста превышает заданную длину textLength на ${originalText.length - textLength}"
            )
    }

    private val originalTextLengthWithoutSpaces = originalText.replace(" ", "").trim().length

    // 1
    fun analyzeEnteredTextAndPrintResult() {
        val messageAboutTextSymbolsCount = when (originalText.length % 2) {
            0 -> "четное"
            else -> "нечетное"
        }
        println(
            "Количество символов : ${originalText.length} \n" +
                    "Количество символов без пробелов : $originalTextLengthWithoutSpaces \n" +
                    "Количество символов в тексте : $messageAboutTextSymbolsCount"
        )
    }

    private fun getPreparedTextWithForbiddenWords(): String {
        var preparedText = originalText
        if (forbiddenWords.isNotEmpty()) {
            forbiddenWords.forEach { preparedText = preparedText.replace(it, "***") }
        }
        return preparedText
    }

    private fun getPreparedTextAfterTrimByMaxLengthWord(pureText: String): String {
        val wordsFromText = pureText.split(" ")
        return if (wordsFromText.size > 1) {
            val sortedByLengthWords =
                wordsFromText.map { Word(value = it, length = it.length) }.toList().sortedBy { it.length }
            val maxLengthWord = sortedByLengthWords.last()
            val separatedTextByMaxLengthWord = pureText.split(maxLengthWord.value).toMutableList()
            if (separatedTextByMaxLengthWord[1].isNotEmpty()) {
                separatedTextByMaxLengthWord[0] = "${separatedTextByMaxLengthWord[0].trim()}..."
            }
            separatedTextByMaxLengthWord[0]
        } else {
            "..."
        }
    }

    fun mapTextToJsonObjectAndPrintResult() {
        val textInJson = JsonObject()
        val pureText = getPreparedTextWithForbiddenWords()
        textInJson.addProperty("length", originalText.length)
        textInJson.addProperty("pure_length", originalTextLengthWithoutSpaces)
        textInJson.addProperty("origin_text", originalText)
        textInJson.addProperty("pure_text", pureText)
        textInJson.addProperty("pure_short_text", getPreparedTextAfterTrimByMaxLengthWord(pureText))
        println(textInJson)
    }
}