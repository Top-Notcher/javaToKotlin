package com.javaToKotlin.lec01

fun main() {
    var number1: Long = 10L      // 바꿀 수 있는 변수
    val number2: Long = 10L      // 바꿀 수 없는 변수

    var number3: Long
//    println(number3)  // complile error

    val number4: Long
    number4 = 10L


    var number5: Long? = 1_000L
    number5 = null

    var person = Person("박현민")
}
