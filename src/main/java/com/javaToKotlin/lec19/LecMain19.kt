package com.javaToKotlin.lec19

import com.javaToKotlin.lec17.java.FruitFilter
import com.javaToKotlin.lec18.Fruit

import com.javaToKotlin.lec19.a.printHelloWorld as printHelloWorldA
import com.javaToKotlin.lec19.b.printHelloWorld as printHelloWorldB

/**
 * 1. Type Alias
 */

fun filterFruits1(fruit: List<Fruit>, filter: (Fruit) -> Boolean) {

}

typealias FruitFilter = (Fruit) -> Boolean
fun filterFruits2(fruit: List<Fruit>, filter: FruitFilter) {

}

// 이름 긴 클래스를 컬렉션에 사용할 때도 간단히 줄일 수 있다.
data class UltraSuperGuardianTribe(
    val name: String
)
typealias USGTMap = Map<String, UltraSuperGuardianTribe>

/**
 * 2. as import
 */
fun main1() {
    printHelloWorldA()
    printHelloWorldB()
}

/**
 * 3. 구조분해와 componentN함수
 */
data class Person(
    val name: String,
    val age: Int
)

class Person2(
    val name: String,
    val age: Int
) {
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int {
        return this.age
    }
}

fun main2() {
    val person = Person("박현민", 100)
//    val (name, age) = person
//    println("이름 : $name , 나이 : $age")

    val name = person.component1()
    val age = person.component2()
}

/**
 * 4. Jump와 Label
 */
fun main3() {
    val numbers = listOf(1, 2, 3)
//    for (number in numbers) {
//        println(number)
//    }
    numbers.map { number -> number + 1 }
        .forEach { number ->
            if (number == 3) {
                return@forEach
            }
            println(number)
        }

    loop@ for(i in 1..100) {
        for(j in 1..100) {
            if(j == 2) {
                break@loop
            }
            println("$i $j")
        }
    }

}

/**
 * 5. TakeIf와 TakeUnless
 */
class Take (
    val number: Int
) {
    fun getNumberOrNull(): Int? {
        return if (number <= 0) {
            null
        } else {
            number
        }
    }

    fun getNumberOrNullV2(): Int? {
        return number.takeIf { it > 0 }
    }

    fun getNumberOrNullV3(): Int? {
        return number.takeUnless { it <= 0 }
    }
}