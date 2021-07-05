fun main() {
    var mul3 = 1
    var mul5 = 1
    for (i in 1..100) {
        var message = ""
        if (mul3 == 3) {
            message += "fizz"
            mul3 = 0
        }
        if (mul5 == 5) {
            message += "buzz"
            mul5 = 0
        }
        if (message == "") println(i)
        else println(message)
        mul3++
        mul5++
    }
}