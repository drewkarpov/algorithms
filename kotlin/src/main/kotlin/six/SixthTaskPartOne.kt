package six

fun main() {
    println(checkEnteredNumberIsEqualKey(33, 7))
}


private fun checkEnteredNumberIsEqualKey(twoCharsNumber: Int, key: Int): Boolean {
    if (twoCharsNumber.toString().length == 2) {
        val numbers = mapNumberToNumbersArray(twoCharsNumber)
        if (numbers[0] + numbers[1] == key || numbers[0] == numbers[1]) {
            return true
        }
    } else {
        throw IllegalArgumentException("число twoCharsNumber должно быть двузначным")
    }
    return false
}

private fun mapNumberToNumbersArray(number: Int): MutableList<Int> {
    val numbers = mutableListOf<Int>()
    number.toString().toCharArray().forEach { numbers.add(it.toString().toInt()) }
    return numbers
}
