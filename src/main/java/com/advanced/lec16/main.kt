package com.advanced.lec16

import com.javaToKotlin.lec16.add

/** example01 : 코틀린에서는 SAM을 람다식으로 인스턴스화 할 수 없다.
 */
fun example01() {
    // 1. 익명함수는 가능!
    val filter1: StringFilter = object : StringFilter {
        override fun predicate(str: String?): Boolean {
            return str?.startsWith("A") ?: false
        }
    }

    // 2. 람다식은 에러
//    val filter2: StringFilter = { s -> s.startsWith("A") }

    // 3. SAM 생성자를 이용한다면 람다식 사용 가능
    val filter3: StringFilter = StringFilter { s -> s.startsWith("A") }
}

/** example02 : 만약 변수에 넣을게 아니라, 파라미터에 넣을거라면 바로 람다식을 쓸 수 있다.
 */
fun example02() {
    consumeFilter({ s -> s.startsWith("A") })
}

fun consumeFilter(filter: StringFilter) {}

/** example03 : 코틀린에서의 SAM interface
 */
fun interface KStringFilter {
    fun predicate(str: String): Boolean
}

/** example04 : 메소드 참조
 */
fun add(a: Int, b: Int) = a + b

fun example04() {
    val add1 = ::add
}

/** example05 : 생성자에 대한 호출 가능 참조
 */
class Person(
    val name: String,
    val age: Int,
)

fun example05() {
   val personConstructor = ::Person
}

/** example06 : 프로퍼티에 대한 호출 가능 참조
 */
fun example06() {
    val personConstructor = Person::name.getter
}

/** example07 : 인스턴스화된 클래스 또는 확장함수에도 적용할 수 있다.
 */
fun example07_1() {
    val p1 = Person("A", 100)
    val boundingGetter = p1::name.getter    // 바인딩된 호출 가능 참조
}

fun Int.addOne(): Int {
    return this + 1
}

fun example07_2() {
    val plus = Int::addOne  // 확장 함수의 호출 가능 참조
}
