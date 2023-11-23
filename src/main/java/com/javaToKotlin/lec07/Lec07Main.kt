package com.javaToKotlin.lec07

import java.lang.IllegalArgumentException

// 1. 주어진 문자열을 정수로 변경하는 예제
fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt();
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다.")
    }
}

// 2. 주어진 문자열을 정수로 변경하는 예제, 실패하면 null을 반환!
fun parseIntOrThrowV2(str: String): Int? {
    return try {
        str.toInt()
    }catch (e: NumberFormatException) {
        null
    }
}
