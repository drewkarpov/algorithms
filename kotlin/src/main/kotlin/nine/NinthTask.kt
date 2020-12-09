package nine


fun main() {
    var stepCounter = 0
    var enteredValueByPlayer = ""
    while (true) {
        println("введите номер ячейки")
        if (stepCounter < 9) {
            enteredValueByPlayer = readLine()!!
        }
        fun makeStep(moveIndex: Int, mark: FieldMark) {
            if (moveIndex > 10 || !GameField.cellIndex.contains(moveIndex)) {
                println("не корректное число , выберите любое доступное: ${GameField.cellIndex}")
            } else {
                loop@ for (firstIndex in GameField.fieldValue.indices) {
                    for (cell in GameField.fieldValue[firstIndex]) {
                        if (!cell.isMarked && cell.index == moveIndex) {
                            GameField.cellIndex.remove(moveIndex)
                            when (mark) {
                                FieldMark.PLAYER -> {
                                    cell.isMarked = true
                                    cell.value = "X"
                                    stepCounter += 1
                                    GameField.printGameField()
                                    if (!GameField.existFreeCells) makeStep(
                                        GameField.cellIndex.random(),
                                        mark = FieldMark.COMPUTER
                                    )
                                }
                                FieldMark.COMPUTER -> {
                                    cell.isMarked = true
                                    cell.value = "O"
                                    stepCounter += 1
                                    GameField.printGameFieldWithComputerStep()
                                    break@loop
                                }
                            }
                        }
                    }
                }
            }
        }
        if (stepCounter < 9) {
            makeStep(enteredValueByPlayer.toInt(), FieldMark.PLAYER)
        } else {
            println("игра закончена")
            break
        }
    }
}