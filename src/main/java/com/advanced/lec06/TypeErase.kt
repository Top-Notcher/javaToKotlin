package com.advanced.lec06

fun main() {
//    val numbers: List = listOf(1, 2, 3) // raw 타입 객체를 만들 수 없다.

    val num = 3
    num.toSuperString() // "Int: 3"

    val str = "ABC"
    str.toSuperString() // "String: ABC"

    val numbers = listOf(1,2,3)
    numbers.filterIsInstance<Float>()   // [2f]
}

/**
 * 타입 소거를 확인할 수 있는 대표적인 코드
 */
fun checkStringList(data: Any) {
    // Error : Cannot check for instance of erased type: List<String>
//    if (data is List<String>) {
//    }

    // data가 List인지 확인할 수 있다.
    if (data is List<*>) {  // star projection을 활용해 최소한 List인지는 확인할 수 있다.
        // data가 List 타입이니 데이터를 가져올 수 있다.
        // 이때 어떤 타입인지는 모르니 Any?로 가져온다.
        val element: Any? = data[0]
    }

    if (data is MutableList<*>) {
//        data.add(3) // MutableList 안에 어떤 타입이 들어있을지 모르니 함부로 데이터를 넣을 수 없다.
    }
}

fun checkMutableList(data: Collection<String>) {
    if (data is MutableList<String>) {
        data.add("Hello World")
    }
}

fun <T> T.toSuperString() {
    // T가 무엇인지 런타임 때도 알 수 없기 때문에 오류가 난다.
//    println("${T::class.java.name}: $this") // 타입 파라미터 정보가 런타임때 소거 되기에 컴파일에러
}

inline fun <reified T> List<*>.hasAnyInstanceOf(): Boolean {
    return this.any { it is T }
}


class TypeErase {
}