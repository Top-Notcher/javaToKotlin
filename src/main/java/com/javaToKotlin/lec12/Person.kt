package com.javaToKotlin.lec12

fun main() {

    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)

}

class Person private constructor(
    var name: String,
    var age: Int
) {

    companion object Factory : Log {
        private const val MIN_AGE = 1

        @JvmStatic  // java의 static 처럼 바로 접근 가능
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("나는 Person 클래스의 동행객체 Factory이다.")
        }
    }
}

object Singleton {
    var a: Int = 0
}