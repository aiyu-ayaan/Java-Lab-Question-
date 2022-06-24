package Kotlin


import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

data class IsPresent(val day: Long, val index: Int)


fun main() {
////    val list = emptyList<Int>()
////
////    val date = Date()
////    val toDate = date.convertDateToTime().convertStringToLongMillis()
////
////    val cal = Calendar.getInstance()
//////    cal.add(Calendar.DATE, +1)
//////    val day1 = cal.time.convertDateToTime().convertStringToLongMillis()
////    cal.add(Calendar.DATE, -7)
////    val day7 = cal.time.convertDateToTime().convertStringToLongMillis()
////
////    cal.add(Calendar.DATE, +8)
////    val day8 = cal.time.convertDateToTime().convertStringToLongMillis()
////
////    println(list.last())
//    val arrayList = arrayListOf<IsPresent>()
//    for (i in 1..3) {
//        arrayList.add(IsPresent(System.currentTimeMillis(), i))
//    }
//    println(arrayList.last())
//    println("Total :- ${arrayList.countTotalClass()}")
    val c: Long = 1644564786
    print("${c.convertLongToTime()} , ${System.currentTimeMillis()}")
}

fun ArrayList<IsPresent>.countTotalClass(): Int {
    var days = 1
    for (index in this) {
        if (
            this.last().day.convertLongToTime() == index.day.convertLongToTime()
        ) {
            days++
            println(index.index)
        }
    }
    return days
}

fun ArrayList<Int>.countSameNumber(arrayList: Int): Int {
    var size = 0
    val arr = arrayListOf<Int>()
    for ((index, i) in this.withIndex()) {
        if (this.last() == i) {
            size++
            if (arrayList - 1 != index) {
                arr.add(index)
            }
        }
    }
    for (i in arr.reversed()) {
        this.removeAt(i)
    }
    return size
}

fun Date.convertDateToTime(): String =
    SimpleDateFormat("dd/MM/yyyy").format(this)

fun Long.convertLongToTime(): String {
    val date = Date(this)
    val df2 = SimpleDateFormat("MMM dd,YYYY hh:mm aa")
    return df2.format(date)
}


fun String.convertStringToLongMillis(): Long? {
    val f = SimpleDateFormat("dd/MM/yyyy")
    try {
        val d = f.parse(this)
        return d.time
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return null
}