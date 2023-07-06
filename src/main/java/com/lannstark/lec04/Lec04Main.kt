package com.lannstark.lec04

fun main() {
    val money1 = JavaMoney(2_000L)
    val copyMoney = money1
    val money2 = JavaMoney(1_000L)

    if(money1 > money2) {
        println("Money1이 Money2보다 금액이 크다.")
    }

    println(money1 === copyMoney)   // true
    println(money1 === money2)      // false
    println(money1 == money2)      // true

    if (fun1() || fun2()) { // Lazy 연산
        println("본문")
    }

    val money3 = Money(1_000L)
    val money4 = Money(2_000L)
    println(money3 + money4)    // Money(amount=3000)
}

fun fun1(): Boolean {
    println("fun 1")
    return true
}

fun fun2(): Boolean {
    println("fun 2")
    return false
}