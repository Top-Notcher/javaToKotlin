package com.lannstark.lec18

data class Fruit(
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long,
) {
    fun nullOrValue(): Unit? {
        TODO("Not yet implemented")
    }

    val isSamePrice: Boolean
        get() = factoryPrice == currentPrice
}

val List<Fruit>.samePriceFilter: List<Fruit>
    get() = this.filter(Fruit::isSamePrice)

fun main() {
    val fruits = listOf(
        Fruit(1,"사과", 1_000, 1_000),
        Fruit(2,"사과", 1_200, 1_200),
        Fruit(3,"사과", 1_200, 1_200),
        Fruit(4,"사과", 1_000, 1_000),
        Fruit(5,"사과", 1_500, 1_500),
        Fruit(6,"바나나", 3_000,  3_000),
        Fruit(7,"바나나", 3_200,  3_200),
        Fruit(8,"바나나", 2_500,  2_500),
        Fruit(9,"수박", 10_000,1_000),
    )

    /**
     * 1. 필터와 맵
      */
    val apples = fruits.filter { fruit -> fruit.name == "사과" }
    // 필터에서 인덱스가 필요하다면?!
    val apples2 = fruits.filterIndexed { idx, fruit ->
        println(idx)
        fruit.name == "사과"
    }

    val applePrice = fruits.filter { fruit -> fruit.name == "사과" }
        .map { fruit -> fruit.currentPrice }
    // 맵에서 인덱스가 필요하다면?!
    val applePrice2 = fruits.filter { fruit -> fruit.name == "사과" }
        .mapIndexed { idx, fruit ->
            println(idx)
            fruit.currentPrice
        }

    // Mapping의 결과가 null아닌 것만 가져오고 싶다면?!
    val values = fruits.filter { fruit -> fruit.name == "사과" }
        .mapNotNull { fruit -> fruit.nullOrValue() }

    /**
     * 2. 다양한 컬렉션 처리 기능
     */
    // all
    val isAllApple = fruits.all {fruit -> fruit.name == "사과" }
    // none
    val isNoApple = fruits.none {fruit -> fruit.name == "사과" }
    // any
    val isNoApple2 = fruits.any {fruit -> fruit.factoryPrice >= 10_000 }
    // count
    val fruitCount = fruits.count()
    // sortedBy : (오름차순) 정렬을 한다.
    val fruitSort1 = fruits.sortedBy { fruit -> fruit.currentPrice }
    // sortedByDescending : (내림차순) 정렬을 한다
    val fruitSort2 = fruits.sortedByDescending { fruit -> fruit.currentPrice }
    // distinctBy : 변형된 값을 기준으로 중복을 제거한다.
    val distinctFruitNames = fruits.distinctBy { fruit: Fruit -> fruit.name }
        .map { fruit: Fruit -> fruit.name }
    // first : 첫번째 값을 가져온다 (무조건 null이 아니어야함)
    fruits.first()
    // firstOrNull : 첫번째 값 또는 null을 가져온다
    fruits.firstOrNull()
    // last : 마지막 값을 가져온다 (무조건 null이 아니어야함)
    fruits.last()
    // lastOrNull : 첫번째 값 또는 null을 가져온다
    fruits.lastOrNull()

    /**
     * 3. List를 Map으로
     */
    // 과일이름 -> List<과일> 의 Map
    val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
    // id -> 과일 의 Map
    val map2: Map<Long, Fruit> = fruits.associateBy { fruit -> fruit.id }
    // 과일이름 -> List<출고가> Map
    val map3: Map<String, List<Long>> = fruits.groupBy({fruit -> fruit.name}, {fruit -> fruit.factoryPrice})
    // id -> 출고가 Map
    val map4: Map<Long, Long> = fruits.associateBy({fruit -> fruit.id}, {fruit -> fruit.factoryPrice})

    val map5: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
        .filter { (key, value) -> key == "사과" }

    /**
     * 4. 중첩된 컬렉션 처리
     */
    val fruitsInList: List<List<Fruit>> = listOf(
        listOf(
            Fruit(1L, "사과", 1_000, 1_500),
            Fruit(2L, "사과", 1_200, 1_500),
            Fruit(3L, "사과", 1_200, 1_500),
            Fruit(4L, "사과", 1_500, 1_500),
        ),
        listOf(
            Fruit(5L, "바나나", 3_000, 3_200),
            Fruit(6L, "바나나", 3_200, 3_200),
            Fruit(7L, "바나나", 2_500, 3_200),
        ),
        listOf(
            Fruit(8L, "수박", 10_000, 10_000),
        )
    )

    // 출고가와 현재가가 동일한 과일
    val samePriceFruits = fruitsInList.flatMap { list ->
        list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice }
    }
    val samePriceFruits2 = fruitsInList.flatMap { list -> list.samePriceFilter }

    // List<List<Fruit>>를 List<Fruit>로 변경
    fruitsInList.flatten()
}
