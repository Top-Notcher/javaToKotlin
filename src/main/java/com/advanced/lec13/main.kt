package com.advanced.lec13

/** example01 : 고차함수
 * - 파라미터에 함수를 받고 있다. 즉, 고차함수!
 */
fun compute(num1: Int, num2: Int, op: (Int, Int) -> Int): Int {
    return op(num1, num2)
}

// 반환 타입에도 함수가 들어갈 수 있다.
//fun opGenerator(): (Int, Int) -> Int {
//
//}

fun example01() {
    // 람다식
    compute(5, 3) { a, b -> a + b }

    // 익명 함수
    compute(5, 3, fun(a: Int, b: Int) = a + b)
    compute(5, 3, fun(a: Int, b: Int): Int {
        return a + b
    })
    compute(5, 3, fun(a, b) = a + b)
}

/** example02 : 람다식과 익명 함수의 차이
 */
fun iterate(numbers: List<Int>, exec: (Int) -> Unit) {
    for (number in numbers) {
        exec(number)
    }
}

fun example02() {
    // 익명함수
    iterate(listOf(1, 2, 3, 4, 5), fun(num) {
        if (num == 3) {
            return
        }
        println(num)
    })

    // 람다
    iterate(listOf(1, 2, 3, 4, 5)) { num ->
        if (num == 3) {
//            return    // 에러! non-local return (비지역적 반환)
        }
        println(num)
    }
}

/** example03 : 함수 파라미터에 default parameter 저용 간으!
 */
fun compute1(
    num1: Int,
    num2: Int,
    op1: (Int, Int) -> Int = { a, b -> a + b },
    op2: (Int, Int) -> Int = fun(a, b) = a + b,
): Int {
    return op1(num1, num2)
}

/** example04 : 함수 파라미터의 기본값 응용 - 계산기 만들기
 */
fun calculate(num1: Int, num2: Int, oper: Char): Int {
    return when (oper) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '*' -> num1 * num2
        '/' -> {
            if (num2 == 0) {
                throw IllegalArgumentException("0으로 나눌 수 없습니다!")
            } else {
                num1 / num2
            }
        }

        else -> throw IllegalArgumentException("들어올 수 없는 연산자(${oper}입니다!")
    }
}

enum class Operator(
    private val oper: Char,
    val calcFun: (Int, Int) -> Int,
) {
    PLUS('+', { a, b -> a + b }),
    MINUS('-', { a, b -> a - b }),
    MULTIPLY('*', { a, b -> a * b }),
    DIVIDE('/', { a, b ->
        if (b == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다!")
        } else {
            a / b
        }
    }),
}

fun calculate(num1: Int, num2: Int, oper: Operator) = oper.calcFun(num1, num2)