package four

fun main() {
    val numbers = arrayOf(1, -2, 5, 12, 4, 3, 7)
    val key = 1

    checkArrayToExistSumNumbersEqualKey(numbers, key)
}

fun checkArrayToExistSumNumbersEqualKey(numbers: Array<Int>, key: Int): Boolean {
    for (firstIndex in numbers.indices) {
        for (secondIndex in 1 until numbers.size) {
            if (numbers[firstIndex] + numbers[secondIndex] == key) {
                println("сумма ${numbers[firstIndex]} и ${numbers[secondIndex]} равна ключу")
                return true
            }
        }
    }
    println("не найдена сумма чисел, равная ключу")
    return false
}
