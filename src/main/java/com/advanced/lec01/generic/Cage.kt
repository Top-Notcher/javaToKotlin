package com.advanced.lec01.generic

import com.lannstark.lec11.Car


fun main() {
    /**
     * example01
     */
    val cage = Cage()
    cage.put(Carp("잉어"))
//    val carp: Carp = cage.getFirst()              // Error: Type Mismatch
//    val carp: Carp = cage.getFirst() as Carp      // 만약에 넣은게 금붕어였다면?! -> 런타임 에러

    // Safe Type Casting과 Elvis Operator
    val carp: Carp = cage.getFirst() as? Carp?: throw  IllegalArgumentException()


    // generic 활용
    val cage2 = Cage2<Carp>()
    cage2.put(Carp("잉어"))
    val carp2: Carp = cage2.getFirst()

    /**
     * example02
     */
    val goldFishCage = Cage2<GoldFish>()
    goldFishCage.put(GoldFish("금붕어"))

    val fishCage = Cage2<Fish>()
//    fishCage.moveFrom(goldFishCage) // Type Mismatch
}

class Cage {
    private val animals: MutableList<Animal> = mutableListOf()

    fun getFirst(): Animal {
        return animals.first()
    }

    fun put(animal: Animal) {
        this.animals.add(animal)
    }

    fun moveFrom(cage: Cage) {
        this.animals.addAll(cage.animals)
    }
}

class Cage2<T> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T {
        return animals.first()
    }

    fun put(animal: T) {
        this.animals.add(animal)
    }

    fun moveFrom(cage: Cage2<T>) {
        this.animals.addAll(cage.animals)
    }
}
