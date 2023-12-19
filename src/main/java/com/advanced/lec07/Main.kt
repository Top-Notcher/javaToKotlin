package com.advanced.lec07

import com.advanced.lec01.generic.Animal
import com.advanced.lec01.generic.GoldFish
import com.javaToKotlin.lec14.PersonDto

/**
 * 제네릭 클래스 : 여러개의 타입 파라미터를 한 제네릭 클래스에서도 사용 가능!
 */
class TypeErase<T, R, B> {
}

/**
 * 타입 파라미터 새도잉
 */
class CageShadow<T : Animal> {
    fun <T : Animal> addAnimal(animal: T) {

    }
}

/**
 * 제네릭 클래스의 상속
 */
open class CageV1<T : Animal> {
    open fun addAnimal(animal: T) {

    }
}

class CageV2<T : Animal> : CageV1<T>()

class GoldFishCageV2 : CageV1<GoldFish>() {
    override fun addAnimal(animal: GoldFish) {
        super.addAnimal(animal)
    }
}

/**
 * 제네릭 Type Alias
 */
typealias PersonDtoStore = Map<PersonDto, MutableList<PersonDto>>

fun handleCacheStore(store: PersonDto) {

}