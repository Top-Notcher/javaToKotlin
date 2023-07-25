package com.lannstark.lec14

fun main() {
    val dto1 = PersonDto("최태현", 100)
    val dto2 = PersonDto("최태현", 100)
    println(dto1 == dto2)
}

data class PersonDto(
    val name: String,
    val age: Int
)