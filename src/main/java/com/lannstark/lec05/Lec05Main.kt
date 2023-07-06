package com.lannstark.lec05

import java.lang.IllegalArgumentException

fun main() {

}

fun validateScoreIsNotNegative(score: Int) {
    if(score < 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    }
    if(score !in 0..100) {
        throw IllegalArgumentException("score")
    }
}

fun getPassOrFail(score: Int): String {
    return if(score >= 50) {
        "P"
    }else {
        "F"
    }
}

fun getGrade(score: Int): String {
    return if(score >= 90) {
        "A"
    }else if(score >= 80) {
        "B"
    }else if(score >= 70) {
        "C"
    }else {
        "D"
    }
}

fun getGradeWithSwitch(score: Int): String {
    return when(score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")    // smart cast
        else -> false
    }
}

fun judgeNumber(number: Int) {
    when (number) {
        1, 0, -1 -> println("어디서 많이 본 숫자이다.")
        else -> println("1, 0, -1이 아닙니다.")
    }
}

fun judgeNumber2(number: Int) {
    when {
        number == 0 -> println("주어진 숫자는 0입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수 입니다.")
    }
}
