package com.advanced.lec15

/** example01 : inline 함수 파라미터도 인라이닝 될 때
 */
inline fun repeat(times: Int, exec: () -> Unit) {
    for (i in 1..times) {
        exec()
    }
}

fun example01() {
    repeat(2) { println("Hello World") }
}

/** example02 : 함수 파라미터가 인라이닝 안될 경우
 */
fun example02(exec: () -> Unit) {
    repeat(2, exec)
}

/** example03 : noinline
 */
inline fun repeat2(
    times: Int,
    noinline exec: () -> Unit
) {
    for (i in 1..times) {
        exec()
    }
}

/** example04 : inline 함수는 non-local return을 가능하게 한다.
 */
fun example04() {
    iterate1(listOf(1, 2, 3, 4, 5)) { num ->
        if (num == 3) {
            return      // 단, 이 return 은 example04 함수를 return 하게 된다.
        }
        println(num)
    }
}

inline fun iterate1(numbers: List<Int>, exec: (Int) -> Unit) {
    for (number in numbers) {
        exec(number)
    }
}

/** example05 : crossinline 키워드
 */
fun example05() {
    iterate2(listOf(1, 2, 3, 4, 5)) { num ->
        if (num == 3) {
//            return    // 에러!
        }
        println(num)
    }
}

inline fun iterate2(numbers: List<Int>, crossinline exec: (Int) -> Unit) {
    for (number in numbers) {
        exec(number)
    }
}

/** example06 : inline 프로퍼티
 */
class Person(
    val name: String,
) {
    inline val uppercaseName: String
        get() = this.name.uppercase()
}