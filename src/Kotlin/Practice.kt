package Kotlin

fun main() {
    val list = arrayListOf<Int>(1, 2)
    var s = ""
    list.forEach { s += it.toString() }
    println(s)
}

inline fun printName(times: Int, lambda: (Int) -> Unit) {
    lambda.invoke(times)
}
