package com.advanced.lec24

import kotlin.system.measureTimeMillis

/** example01 : repeat
 */
fun example01() {
    repeat(3) {
        println("Hello World")
    }
}

/** example02 : TODO 함수
 */
fun example02() {
    TODO("main 함수 구현")
}


/** example03 : measureTimeMillis
 * - 가볍게 성능을 확인해 볼 때 유용하다.
 */
fun example03() {
    val timeMillis = measureTimeMillis {
        val a = 1
        val b = 2
        val result =  a + b
    }
}

/** example04 : require
 * - 파라미터를 검증하기 유용하다.
 * - IllegalArgumentException을 던진다.
 */
fun acceptOnlyTwo(num: Int) {
    require(num == 2) { "2만 허용!" } // 2가 아닐 때 Exception 발생!
}

/** example05 : check
 * - 상태 혹은 멤버 변수를 검증하기 유용하다.
 * - IllegalStateException을 던진다.
 */
class Person {
    val status: PersonStatus = PersonStatus.PLAYING

    fun sleep() {
        check(this.status == PersonStatus.PLAYING) { "에러 메시지!" }
    }

    enum class PersonStatus {
        PLAYING, SLEEPING
    }
}

/** example06 : runCatching
 * - 예외 처리를 간단히 구성할 수 있다.
 */
fun example06() {
    val result: Result<Int> = runCatching { 1 / 0 }
}



