package com.effectiveKotlin

/** 1. 읽기 전용 프로퍼티(val)
 */
val name: String? = "Marton"
val surname: String = "Braun"

val fullName: String?
    get() = name?.let { "$it $surname" }

val fullName2: String? = name?.let { "$it $name" }

/** 스마트 캐스트 : if문으로 null인지 검사하면, 조건문 본문 내부에서는 null 아니라는 것이 확인된 것
 * - fullName은 게터로 정의 했으므로 스마트 캐스트를 할 수 없다.
 * - 게터를 활용하므로, 값이 사용하는 시점의 name에 따라서 다른 결과가 나올 수 있기 때문이다.
 */
fun example01() {
    if (fullName != null) {
//        println(fullName.length)    // complie error
    }

    if (fullName2 != null) {
        println(fullName2.length)
    }
}



/**  2. 읽기 전용에서 mutable로 변경해야 한다면, 복제(copy)를 통해서 새로운 mutable 컬렉션을 만드는 list.toMutableList를 활용
 */
fun example02() {
    val list = listOf(1, 2, 3)

    val mutableList = list.toMutableList()
    mutableList.add(4)
}