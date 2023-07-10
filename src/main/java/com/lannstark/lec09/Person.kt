package com.lannstark.lec09

import java.lang.IllegalArgumentException

fun main() {
//    val person = Person("박현민", 27)
    val person = JavaPerson("박현민", 27)
    println(person.name)
    person.age = 10
    print(person.age)

    // 3.
    val person2 = Person("박현민")
}

class Person(name: String, var age: Int) {
    // 2.
    init {  // 클래스가 초기화되는 시점에 실행
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
        println("초기화 블록")
    }

    // 3.
    constructor(name: String) : this(name, 1) {
        println("첫 번째 부생성자")
    }

    constructor() : this("홍길동") {
        println("두 번째 부생성자")
    }

    // 4.
//    fun isAdult(): Boolean {
//        return this.age >= 20
//    }

    val isAdult: Boolean
        get() = this.age >= 20

    // 5.
//    val name = name
//        get() = field.uppercase()

//    fun getUppercaseName(): String {
//        return this.name.uppercase()
//    }

//    val uppercaseName: String
//        get() = this.name.uppercase()

    var name = name
        set(value) {
            field = value.uppercase()
        }

}
