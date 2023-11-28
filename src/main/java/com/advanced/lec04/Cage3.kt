package com.advanced.lec04

import com.advanced.lec02.Animal
import com.advanced.lec02.Fish

fun main() {
    val fishCage = Cage3<Fish>()
    val animalVcage: Cage3<Animal> = fishCage
}



// Cage3는 오직 생산만 하고 있다. - 이런 경우 클래스 자체를 공변하게 만들 수 있다! (배열에 값을 넣지 않기 때문!)
class Cage3<out T> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T {
        return this.animals.first()
    }

    fun getAll(): List<T> {
        return this.animals
    }
}