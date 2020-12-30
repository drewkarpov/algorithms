package twenty_five

class MethodTimeMeter {

    fun printTimeOfWorkMethod(someMethod: () -> Unit) {
        val startTime = System.currentTimeMillis()
        run(someMethod)
        val endTime = System.currentTimeMillis() - startTime
        println("Время работы метода : $endTime мс")
    }

}

fun main() {
    val timer = MethodTimeMeter()
    val workTime = 3000L

    fun someMethod() {
        println("Начал работу")
        Thread.sleep(workTime)
        println("Поспал $workTime мс и закончил работу")
    }
    timer.printTimeOfWorkMethod {
        someMethod()
    }

}