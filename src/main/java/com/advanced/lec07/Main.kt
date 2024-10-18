package com.advanced.lec07

import com.advanced.lec01.generic.Animal
import com.advanced.lec01.generic.Cage
import com.advanced.lec01.generic.Carp
import com.advanced.lec01.generic.GoldFish
import com.javaToKotlin.lec14.PersonDto

/** example01 : 여러개의 타입 파라미터를 한 제네릭 클래스에서도 사용 가능!
 */
class TypeErase<T, R, B> {
}

/** added example01 : 타입 파라미터 새도잉
 */
class CageShadow<T : Animal> {
    fun <T : Animal> addAnimal(animal: T) {

    }
}

fun addedExample01() {
    val cage = CageShadow<GoldFish>()
    cage.addAnimal(GoldFish("금붕어"))
    cage.addAnimal(Carp("잉어"))  // 문제점 : 잉어도 들어가버린다!
}

/** added example02 : 제네릭 클래스의 상속
 */
open class CageV1<T : Animal> {
    open fun addAnimal(animal: T) {

    }
}

/** 1. 상위 클래스의 제약조 건이 하위 클래스의 제약 조건에 전파된다.
 * - 해당 T 두 개가 같은 제약 조건을 가지고 있어야 한다.
 */
class CageV2<T : Animal> : CageV1<T>()

/** 2. 아예 특정 타입 파라미터를 정할 수도 있다.
 * - 오버라이드 한 부분의 타입이 명시적으로 적혀있다.
 */
class GoldFishCageV2 : CageV1<GoldFish>() {
    override fun addAnimal(animal: GoldFish) {
        super.addAnimal(animal)
    }
}

/** added example03 : 제네릭과 Type Alias
 */
fun handleCacheStore1(store: Map<PersonDtoKey, MutableList<PersonDto>>) {

}

typealias PersonDtoStore = Map<PersonDtoKey, MutableList<PersonDto>>
fun handleCacheStore2(store: PersonDtoStore) {

}