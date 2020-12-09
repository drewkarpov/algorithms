package nine

data class Cell(
    val index: Int,
    var value: String? = null,
    var isMarked: Boolean = false
) {
    override fun toString(): String {
        return value ?: index.toString()
    }
}

enum class FieldMark {
    PLAYER, COMPUTER
}

object GameField {
    val fieldValue = arrayOf(
        arrayOf(Cell(1), Cell(2), Cell(3)),
        arrayOf(Cell(4), Cell(5), Cell(6)),
        arrayOf(Cell(7), Cell(8), Cell(9))
    )
    val cellIndex = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val existFreeCells: Boolean
        get() {
            return cellIndex.size == 0
        }

    fun printGameField() {
        for (array in fieldValue) {
            println("${array[0]} | ${array[1]} | ${array[2]}")
            println("_________")
        }
    }

    fun printGameFieldWithComputerStep() {
        println()
        println("Ход компуктера")
        println()
        printGameField()
    }
}