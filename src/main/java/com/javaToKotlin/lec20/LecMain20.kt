package com.javaToKotlin.lec20

import com.javaToKotlin.lec09.Person

/**
 * 1. scope function 이란?
 */
fun printPerson(person: Person?) {
//    if(person != null) {
//        println(person.name)
//        println(person.age)
//    }
    person?.let {
        println(it.name)
        println(it.age)
    }
}

/**
 * 2. scope function 의 분류
 */
fun printPerson2(person: Person) {
    val value1 = person.let {
        it.age
    }

    val value2 = person.run {
        this.age
    }

    val value3 = person.also {
        it.age
    }

    val value4 = person.apply {
        this.age
    }

    val person = Person("박현민", 100)
    with(person) {
        println(name)
        println(this.age)
    }
}

/**
 * 3. 언제 어떤 scope function을 사용해야 할까?
 */
fun main1() {
    // 1. let
    val strings = listOf("APPLE", "CAR")
    strings.map { it.length }
        .filter { it > 3 }
//        .let(::println)
        .let { lengths -> println(lengths) }

    val str = "abc"
    val length = str?.let {
        println(it.uppercase())
        it.length
    }

    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first()
        .let {firstItem ->
            if (firstItem.length >= 5) firstItem else "!$firstItem!"
        }.uppercase()
    println(modifiedFirstItem)
}

// also
fun main2() {
    mutableListOf("one", "two", "three")
        .also { println("The list elements before adding new one: $it") }
        .add("four")

    val numbers = mutableListOf("one", "two", "three")
    println("The list elements before adding new one: $numbers")
    numbers.add("four")
}


