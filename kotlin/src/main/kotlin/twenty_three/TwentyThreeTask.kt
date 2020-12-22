package twenty_three

fun main() {
    println(
        checkArrayOfArrays(
            currentArray = arrayOf(arrayOf<Any>(1, 2, 4), arrayOf<Any>(2, 4), arrayOf<Any>(4, 5, 1)),
            number = 323
        )
    )
}

fun checkArrayOfArrays(currentArray: Array<Array<Any>>, number: Int): Boolean {
    val listWithCountOfArrays = currentArray.map { it.size }.toList()
    return listWithCountOfArrays == getListOfNumbers(number)
}

fun getListOfNumbers(number: Int): MutableList<Int> {
    val args = mutableListOf<Int>()
    when (number) {
        in 0..9 -> {
            args.add(number)
        }
        in 10..99 -> {
            val tens = number / 10
            val units = number - tens * 10
            args.add(tens)
            args.add(units)
        }
        in 100..999 -> {
            val hundreds = number / 100
            val tens = (number - hundreds * 100) / 10
            val units = number - hundreds * 100 - tens * 10
            args.add(hundreds)
            args.add(tens)
            args.add(units)
        }
        else -> {
            throw IllegalArgumentException("число должно быть больше нуля и меняше 999")
        }
    }
    return args
}