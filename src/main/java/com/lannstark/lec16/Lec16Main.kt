package com.lannstark.lec16

import com.lannstark.lec16.java.Person
import java.lang.IllegalArgumentException

fun main() {
    val person = Person("A", "B",100)
    println(person.nextYearAge())   // 멤버 함수

    val train: Train = Train()
    train.isExpensive() // Train의 확장함수

    val srt1: Train = Srt()
    srt1.isExpensive()  // Train의 확장함수

    val srt2: Srt = Srt()
    srt2.isExpensive()  // Srt의 확장함수

    // 중위 함수
    3.add(4)
    3.add2(4)
    3 add2 4


}

// 멤버함수와 확장함수의 시그니처가 같다면?!
fun Person.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}


// 확장함수가 오버라이드 된다면?!
open class Train(
    val name: String = "새마을기차",
    val price: Int = 5_000
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장함수")
    return this.price >= 10000
}

class Srt : Train("SRT", 40_000)

fun Srt.isExpensive(): Boolean {
    println("Srt의 확장함수")
    return this.price >= 10000
}

// 중위 함수
fun Int.add(other: Int): Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {
    return this + other
}

// 지역 함수
fun createPerson(firstName: String, lastName: String): Person {
//    if(firstName.isEmpty()) {
//        throw IllegalArgumentException("firstName은 비어있을 수 없습니다! 현재 값 : $firstName")
//    }
//    if(lastName.isEmpty()) {
//        throw IllegalArgumentException("lastName 비어있을 수 없습니다! 현재 값 : $lastName")
//    }
    fun validateName(name: String, fieldName: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("$firstName 은 비어있을 수 없습니다! 현재값 : $name")
        }
    }
    validateName(firstName, "firstName")
    validateName(lastName, "lastName")

    return Person(firstName, lastName, 1)
}