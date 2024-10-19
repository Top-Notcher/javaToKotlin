package com.advanced.lec14

/** example01 : 함수 리터럴 호출하기
 */
fun example01() {
    val add1 = { a: Int, b: Int -> a + b }
    add1.invoke(1, 2)
    add1(1, 2)

    // 확장 함수 일 시
    val add2 = fun Int.(other: Long): Int = this + other.toInt()
    add2.invoke(1, 2)
    add2(1, 2)
    5.add2(3L)
}

/** example02 : Closure를 사용한다면, 컴파일 시 복잡해진다!
 */
fun example02() {
    var num = 5
    num += 1
    val plusOne: () -> Unit = { num += 1 }
}