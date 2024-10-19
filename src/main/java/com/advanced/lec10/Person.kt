package com.advanced.lec10

import kotlin.properties.Delegates.notNull
import kotlin.properties.Delegates.observable
import kotlin.properties.Delegates.vetoable

/** example01 : notNull()
 */
class Person1 {
    var age: Int by notNull()
}

/** example02 : observable
 * - setter 호출마다 실행
 */
class Person2 {
    var age: Int by observable(20) { _, oldValue, newValue ->
        println("옛날 값 : $oldValue / 새로운 값 : $newValue")
    }
}

fun example02 () {
    val p = Person2()
    p.age = 30  // 옛날 값 : 20 / 새로운 값 : 30
}

/** example03 : vetoable
 */
class Person3 {
    var age: Int by vetoable(20) { _, _, newValue ->
        newValue >= 1
    }
}

/** example04 : 또 다른 프로퍼티로 위임하기
 */
class Person4 {
    @Deprecated("age를 사용하세요!", ReplaceWith("age"))
    var num: Int = 0

    var age: Int by this::num
}

/** example : Map
 * - getter가 호출되면 map["name"] 또는 map["age"] 를 찾는다!
 */
class Person5(map: Map<String, Any>) {
    val name: String by map
    val age: Int by map
}

fun example05() {
    val person = Person5(mapOf("name" to "John"))
    println(person.name)
    println(person.age) // 예외 발생
}