package com.advanced.lec05

import com.advanced.lec01.generic.Animal
import javax.swing.text.StyledEditorKit.BoldAction

fun main() {
    val cage = Cage5(mutableListOf(Eagle(), Sparrow()))
    cage.printAfterSorting()
}

abstract class Bird(
    name: String,
    private val size: Int
) : Animal(name), Comparable<Bird> {
    override fun compareTo(other: Bird): Int {
        return this.size.compareTo(other.size)
    }
}

class Sparrow : Bird("참새", 100)
class Eagle : Bird("독수리", 500)


/** 단일 제네릭 제약
 */
//class Cage5<T : Animal> { ... }

/** 복수 제네릭 제약
 */
class Cage5<T> (
    private val animals: MutableList<T> = mutableListOf()
) where T : Animal, T : Comparable<T> {

    fun printAfterSorting() {
        this.animals.sorted()
            .map { it.name }
            .let { println(it) }
    }

    fun getFirst(): T {
        return animals.first()
    }

    fun put(animal: T) {
        this.animals.add(animal)
    }

    fun moveFrom(otherCage: Cage5<T>) {
        this.animals.addAll(otherCage.animals)
    }

    fun moveTo(otherCage: Cage5<T>) {
        otherCage.animals.addAll(this.animals)
    }
}

/** 두 리스트의 겹치는 값 여부 확장함수
 * - 제네릭의 활용
 * - List<Int> 이건 List<String> 이건 모든 List에 대해 활용 가능하다.
 */

fun <T> List<T>.hasIntersection(other: List<T>): Boolean {
    return (this.toSet() intersect other.toSet()).isNotEmpty()
}