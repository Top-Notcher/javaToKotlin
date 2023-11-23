package com.javaToKotlin.lec15

fun main() {
    // 1. 배열
    val array = arrayOf(100, 200)
    array.plus(300)

    for (i in array.indices) {
        println("${i} ${array[i]}")
    }

    for ((idx, value) in array.withIndex()) {
        println("$idx $value")
    }

    // 2. List
    val numbers = listOf(100, 200)
    val emptyList = emptyList<Int>()
    printNumbers(emptyList())


    // 하나만 가져오기
    println(numbers[0])

    // For Each
    for (number in numbers) {
        println(number)
    }

    // 전통적인 For문
    for ((idx, value) in numbers.withIndex()) {
        println("$idx $value")
    }

    // 가변 리스트
    val numbers2 = mutableListOf(100, 200)
    numbers2.add(300)

    // 3. Set
    val numbers3 = setOf(100, 200)

    // For Each
    for (number in numbers3) {
        println(number)
    }

    // 전통적인 For 문
    for ((index, number) in numbers3.withIndex()) {
        println("$index $number")
    }

    // 가변집합을 만들고 싶다면?
    val numbers4 = mutableSetOf(100, 200)

    // 4. Map
    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"

    mapOf(1 to "MONDAY", 2 to "TUESDAY")

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }

}

private fun printNumbers(numbers: List<Int>) {

}