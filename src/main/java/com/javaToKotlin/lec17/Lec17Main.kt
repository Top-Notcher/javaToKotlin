package com.javaToKotlin.lec17

import com.javaToKotlin.lec17.java.Fruit
import java.io.BufferedReader
import java.io.FileReader

fun main() {
    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_000),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000),
    )

    // 람다를 만드는 방법 1
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    // 람다를 만드는 방법2
    val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }

    isApple(fruits[0])
    isApple.invoke(fruits[0])

    filterFruits(fruits, isApple)
    filterFruits(fruits) { it.name == "사과" }

    var targetFruitName = "바나나"
    targetFruitName = "수박"
    filterFruits(fruits) { it.name == targetFruitName }
}

private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
//    val results = mutableListOf<Fruit>()
//    for (fruit in fruits) {
//        if(filter(fruit)) {
//            results.add(fruit)
//        }
//    }
//
//    return results
    return fruits.filter(filter)
}

fun readFile(path: String) {
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.readLine())
    }
}