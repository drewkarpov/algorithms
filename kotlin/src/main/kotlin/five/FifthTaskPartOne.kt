package five

const val alphabet = "abcdefghijklmnopqrstuvwxyz"

fun main() {
    val someText = "SCKS fdlDvlD"
    val encodedText = getEncodedText(someText)

    println(someText)
    println(encodedText)
    println(getDecodedText(encodedText))
}


private fun getEncodedText(text: String): String {
    return getPreparedTextByCharsMap(text, encoderMap)
}

private fun getDecodedText(text: String): String {
    return getPreparedTextByCharsMap(text, decoderMap)
}

fun getPreparedTextByCharsMap(text: String, charsMap: MutableMap<Char, Char>): String {
    val charsFromText = text.toCharArray()
    for (index in charsFromText.indices) {
        if (!charsFromText[index].isLetter()) {
            continue
        }
        if (charsFromText[index].isLowerCase()) {
            charsFromText[index] = charsMap[charsFromText[index].toLowerCase()]!!.toUpperCase()
        } else {
            charsFromText[index] = charsMap[charsFromText[index].toLowerCase()]!!
        }

    }
    var resultText = ""
    charsFromText.forEach {
        resultText += it
    }
    return resultText
}


val encoderMap: MutableMap<Char, Char> = mutableMapOf()
    get() {
        val charsFromAlphabet = alphabet.toCharArray()
        for (index in charsFromAlphabet.indices) {
            if (index == charsFromAlphabet.size - 1) {
                field[charsFromAlphabet[index]] = charsFromAlphabet[0]
            } else {
                if (index < charsFromAlphabet.size - 1)
                    field[charsFromAlphabet[index]] = charsFromAlphabet[index + 1]
            }
        }
        return field
    }

val decoderMap: MutableMap<Char, Char> = mutableMapOf()
    get() {
        val charsFromAlphabet = alphabet.toCharArray()
        for (index in charsFromAlphabet.indices) {
            if (index - 1 < 0) {
                field[charsFromAlphabet[0]] = charsFromAlphabet[charsFromAlphabet.size - 1]
            } else {
                field[charsFromAlphabet[index]] = charsFromAlphabet[index - 1]
            }
        }
        return field
    }