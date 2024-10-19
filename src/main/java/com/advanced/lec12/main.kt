package com.advanced.lec12

/** example01 : sequence
 * - 우리는 데이터를 조작할 때 Collection을 사용한다.
 */
fun example01() {
    val fruits = listOf(
        MyFruit("사과", 1000L),
        MyFruit("바나나", 3000L)
    )

    val avg = fruits.asSequence()
        .filter { it.name == "사과" }
        .map { it.price }
        .take(10_000)
        .average()
}

data class MyFruit (
    val name: String,
    val price: Long,    // 1,000원부터 20,000원 사이
)