package ten

fun main() {
    println(getNumberInBinarySystem(124))
}

fun getNumberInBinarySystem(number: Int): String {
    var currentNumber = number
    var resultNumber: Int
    var result = ""
    while (currentNumber != 0) {
        resultNumber = currentNumber % 2;
        result = "${resultNumber}${result}"
        currentNumber /= 2
    }
    return result
}
