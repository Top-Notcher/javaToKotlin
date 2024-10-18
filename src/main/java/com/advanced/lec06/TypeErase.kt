package com.advanced.lec06

fun example01() {
    /** example 01 : raw 타입 객체를 만들 수 없다.
     */
//    val numbers: List = listOf(1, 2, 3)
}


fun checkStringList(data: Any) {
    /** example 02 : 타입 소거를 확인할 수 있는 대표적인 코드
     * - 런타임 때는 String 정보가 사라지기에 List<String> 인지 알 수 없다!
     * - Error : Cannot check for instance of erased type: List<String>
     */
//    if (data is List<String>) { ... }


    /** example 03 : 타입 소거를 확인할 수 있는 대표적인 코드
     * - data가 List인지 확인할 수 있다. star projection을 활용해 최소한 List인지는 확인할 수 있다.
     * - data가 List 타입이니 데이터를 가져올 수 있다. 이때 어떤 타입인지는 모르니 Any?로 가져온다.
     */
    //
    if (data is List<*>) {
        val element: Any? = data[0]
    }

    /**
     * - MutableList 안에 어떤 타입이 들어있을지 모르니 함부로 데이터를 넣을 수는 없다.
     */
    if (data is MutableList<*>) {
//        data.add(3)
    }
}

/** example 04 : 똑똑한 코틀린 컴파일러
 */
fun checkMutableList(data: Collection<String>) {
    if (data is MutableList<String>) {
        data.add("Hello World")
    }
}

/** example 05 : 제네릭 함수는 런타임 때 타입이 사라진다.
 */
fun example05() {
    val num = 3
    num.toSuperString() // "Int: 3"

    val str = "ABC"
    str.toSuperString() // "String: ABC"


}

/**
 * - T가 무엇인지 런타임 때도 알 수 없기 때문에 오류가 난다.
 * - 타입 파라미터 정보가 런타임때 소거 되기에 컴파일 에러
 */
fun <T> T.toSuperString() {
//    println("${T::class.java.name}: $this")
}

/** 각 타입별로 만드는 방법
 */
fun List<*>.hasAnyInstanceOfString(): Boolean {
    return this.any { it is String }
}
fun List<*>.hasAnyInstanceOfInt(): Boolean {
    return this.any { it is Int }
}

/** 위의 함수 2개를 제네릭으로 바꿔보자!
 * - 런타임 시 타입이 소거되기 때문에 T의 타입을 모른다.
 */
//fun <T> List<*>.hasAnyInstanceOf(): Boolean {
//    return this.any { it is T }
//}

/** reified 키워드 + inline 함수로 문제 해결하기!
 * - inline : 함수 자체가 호출되는 것이 아니라, 함수의 본문이 복붙
 */
inline fun <reified T> List<*>.hasAnyInstanceOf(): Boolean {
    return this.any { it is T }
}

/** example 06 : reified 키워드 + inline 함수 예시
 */
fun example06() {
    val numbers = listOf(1,2f,3.0)
    // 내가 가진 리스트 중에 특정 타입들만 필터링
    numbers.filterIsInstance<Float>()   // [2f]
}