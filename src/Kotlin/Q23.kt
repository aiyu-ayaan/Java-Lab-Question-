package Kotlin

/**
 * Simple generics class
 */
interface Demo<T> {
    fun printData(): T
}

/**
 * Class that extends Demo Class
 */
class DemoImp<T>(
    private val data: T
) : Demo<T> {
    override fun printData(): T = data
}

fun main() {
    var demo: Demo<Int>? = null
    demo?.let {
        it.printData()
    }
    demo = DemoImp(3)
}