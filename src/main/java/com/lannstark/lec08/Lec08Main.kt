package com.lannstark.lec08

fun main() {
    repeat("Hello World", useNewLine = false)

    printNameAndGender(name = "박현민",gender = "male")

    printAll("A", "B", "C")
    val array = arrayOf("A", "B", "C")
    printAll(*array)
}

// 1. 두 정수를 받아 더 큰 정수를 반환하는 예제
fun max(a: Int, b: Int) = if (a > b) a else b

// 2. 주어진 문자열을 N번 출력하는 예제
fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if(useNewLine) {
            println(str)
        }else {
            print(str)
        }
    }
}

// 3.
fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}

// 4. 같은 타입의 여러 파라미터 받기 (가변인자)
fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}