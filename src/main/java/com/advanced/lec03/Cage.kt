package com.advanced.lec03


fun main() {
    /**
     * example02
     */
    val goldFishCage = Cage2<GoldFish>()
    goldFishCage.put(GoldFish("금붕어"))

    val fishCage = Cage2<Fish>()
    fishCage.moveFrom(goldFishCage)

    val first: Fish = fishCage.getFirst()

    /**
     * example03
     */
    val fishCage2 = Cage2<Fish>()

    val goldFishCage2 = Cage2<GoldFish>()
    goldFishCage2.put(GoldFish("금붕어"))
    goldFishCage2.moveTo(fishCage2)     // Type Mismatch - Cage2<Fish>가 Cage2<GoldFish>의 하위 타입이어야 한다.
                                        // Cage2를 moveTo 함수에서 반공변하게 만들어야한다!
}

class Cage2<T> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T {
        return animals.first()
    }

    fun put(animal: T) {
        this.animals.add(animal)
    }

    fun moveFrom(otherCage: Cage2<out T>) {
        otherCage.getFirst()
//        otherCage.put("test") // error! because out
        this.animals.addAll(otherCage.animals)
    }

    fun moveTo(otherCage: Cage2<in T>) {
        otherCage.animals.addAll(this.animals);
    }
}
