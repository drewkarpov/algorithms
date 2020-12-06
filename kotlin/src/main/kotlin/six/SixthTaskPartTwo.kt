package six

fun main() {
    println(checkEvenAndOddNumbersFromValueIsEqual(2333221))
}


private fun checkEvenAndOddNumbersFromValueIsEqual(number: Int): Boolean {
    val numbers = mapNumberToNumbersArray(number)
    val evenNumbers = mutableListOf<Int>()
    val oddNumbers = mutableListOf<Int>()

    for (index in 0 until numbers.size) {
        if (index % 2 == 0) oddNumbers.add(numbers[index]) else evenNumbers.add(numbers[index])
    }
    if (evenNumbers.sum() == oddNumbers.sum()) {
        return true
    }
    return false
}

private fun mapNumberToNumbersArray(number: Int): MutableList<Int> {
    val numbers = mutableListOf<Int>()
    number.toString().toCharArray().forEach { numbers.add(it.toString().toInt()) }
    return numbers
}
