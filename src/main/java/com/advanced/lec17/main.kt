package com.advanced.lec17

import java.time.LocalDate

/** example01 연산자 오버로딩
 */
data class Point(
    val x: Int,
    val y: Int,
) {
    fun zeroPointSymmetry(): Point = Point(-x, -y)

    operator fun unaryMinus(): Point {
        return Point(-x, -y)
    }

    operator fun inc(): Point {
        return Point(x + 1, y + 1)
    }
}

fun example01() {
    var point = Point(20, -10)
    println(point.zeroPointSymmetry())
    println(-point)
    println(++point)
}

/** example02 : 사칙연산 역시 오버로딩 가능!
 */
fun example02() {
    // 2023-01-04
    LocalDate.of(2023, 1, 1).plusDays(3)

    // 활용!
    LocalDate.of(2023, 1, 1) + Days(3)

    LocalDate.of(2023, 1, 1) + 3.d
}

data class Days(val day: Long)

operator fun LocalDate.plus(days: Days): LocalDate {
    return this.plusDays(days.day)
}

val Int.d: Days
    get() = Days(this.toLong())

/** example03 : 복합 대입 연산자는 조금 복잡하다.
 */
fun example03() {
    // 복합 대입 연산자 예시
    var a = 3
    a += 4

    // 복합 대입 연산자 존재!
    val list1 = mutableListOf("A", "B", "C")
    list1 += "D"

    // 복합 대입 연산자가 존재하지 않는다!
    var list2 = listOf("A", "B", "C")
    list2 += "D"    // list = list + "D" 로 동작 & 새로운 리스트를 만들어 반환!

    // val 연산자 일 때
    val list3 = listOf("A", "B", "C")
//    list3 += "D"    // 컴파일 에러!

}

