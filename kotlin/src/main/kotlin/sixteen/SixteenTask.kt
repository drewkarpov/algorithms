package sixteen

class QueueWrapper {
    private var numbers = mutableListOf<Int>()

    fun add(number: Int) {
        numbers.add(number)
    }

    fun getFirst(): Int? {
        return if (numbers.size == 0) {
            null
        } else {
            val number = numbers.first()
            numbers.remove(numbers.first())
            number
        }
    }

    fun getLast(): Int? {
        return if (numbers.size == 0) {
            null
        } else {
            val number = numbers.last()
            numbers.remove(numbers.last())
            number
        }
    }

    fun reverse() {
        numbers.reverse()
    }

    fun append(number: Int) {
        numbers = (listOf(number) + numbers).toMutableList()
    }

}

fun main() {
    val queueWrapper = QueueWrapper()
    queueWrapper.add(5)
    queueWrapper.add(6)
    queueWrapper.add(8)
    queueWrapper.append(12)
    queueWrapper.reverse()
    println(queueWrapper)

}