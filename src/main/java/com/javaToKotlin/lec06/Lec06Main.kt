package com.javaToKotlin.lec06

fun main() {
    // 1.
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) {
        println(number)
    }

    // 2.
    for (i in 1..3) {
        println(i)
    }
    for (i in 3 downTo 1) {
        println(i)
    }

    // 3.
    for (i in 1..5 step 2) {
        println(i);
    }

    // 4.
    var i1 = 1
    while(i1 <= 3) {
        println(i1)
        i1++
    }
}