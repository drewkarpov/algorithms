package twenty_two


fun main() {
    val inputStringWithParameters = "--stable-mode --ip=129.22.341.11 --online-mode --port=4455"
    getParametersFromString(inputStringWithParameters)

}


private fun getParametersFromString(inputStringWithParameters: String) {
    val prefix = "--"
    val separatedStringWithParameters = inputStringWithParameters.split(" ")
    val parameters = mutableMapOf<String, Any>()

    for (param in separatedStringWithParameters) {
        val separatedParams = param.split("=")
        if (calculateHyphenCount(separatedParams.first()) != 2) {
            throw IllegalArgumentException("неправильно введен параметр $param")
        }
        when (separatedParams.size) {
            2 -> parameters[separatedParams.first().replace(prefix, "")] = separatedParams[1]
            1 -> parameters[separatedParams.first().replace(prefix, "")] = true
            else -> {
                throw IllegalArgumentException("неправильно введен параметр $param")
            }
        }
    }
    println(parameters.map { "${it.key} => ${it.value}" }.toList())

}

private fun calculateHyphenCount(word: String): Int {
    var counter = 0
    for (char in word.toCharArray()) {
        if (char.toString() != "-") {
            break
        }
        counter += 1
    }
    return counter
}