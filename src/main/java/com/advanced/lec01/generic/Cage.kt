package com.advanced.lec01.generic


fun example01() {
    /**
     * example01
     */
    val cage = Cage()
    cage.put(Carp("잉어"))

    // 1. Error: Type Mismatch -> 컴파일 에러
//    val carp1: Carp = cage.getFirst()

    // 2. 만약에 넣은게 금붕어였다면?! -> 런타임 에러
    val carp2: Carp = cage.getFirst() as Carp

    // 3. Safe Type Casting과 Elvis Operator -> Exception 이 발생할 수 있다!
    val carp3: Carp = cage.getFirst() as? Carp?: throw  IllegalArgumentException()

    // 4. generic 활용
    val cage2 = Cage2<Carp>()
    cage2.put(Carp("잉어"))
    val carp4: Carp = cage2.getFirst()
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
