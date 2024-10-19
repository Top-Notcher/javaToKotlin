package com.advanced.lec11

import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/** example01 : 위임 객체를 만들기 위해 필요한 것
 */
class LazyInitProperty1<T>(val init: () -> T): ReadOnlyProperty<Any, T> {
    private var _value: T? = null
    private val value: T
        get() {
            if (_value == null) {
                this._value = init()
            }
            return _value!!
        }

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return value
    }
}

/** example02 : 위임 프로퍼티와 위임 객체를 연결할 때 로직 끼워넣기
 * - 프로퍼티의 이름이 "name"일 때만 정상 동작해야 하는 위임 객체
 */
fun example02() {
    Person5()
}

class Person5 {
    val name by DelegateProperty("최태현")     // 정상동작 O
    val country by DelegateProperty("한국")    // 정상동작 X
}

class DelegateProvider(
    private val initValue: String
) {
    operator fun provideDelegate(thisRef: Any, property: KProperty<*>): DelegateProperty {
        if (property.name != "name") {
            throw IllegalArgumentException("name만 연결 가능합니다!")
        }
        return DelegateProperty(initValue)
    }
}

class DelegateProvider2(
    private val initValue: String
) :PropertyDelegateProvider<Any, DelegateProperty> {
    override fun provideDelegate(thisRef: Any, property: KProperty<*>): DelegateProperty {
        if (property.name != "name") {
            throw IllegalArgumentException("name만 연결 가능합니다!")
        }
        return DelegateProperty(initValue)
    }
}

class DelegateProperty (
    private val initValue: String
) : ReadOnlyProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return initValue
    }
}

/** example03 : 위임 클래스
 */
interface Fruit {
    val name: String
    val color: String
    fun bite()
}

open class Apple : Fruit {
    override val name: String
        get() = "사과"
    override val color: String
        get() = "빨간색"

    override fun bite() {
        print("사과 톡톡 아삭")
    }
}

/** example03 - 1
 * - 중복 존재!
 */
class GreenApple1 : Fruit {
    override val name: String
        get() = "사과"
    override val color: String
        get() = "초록색"

    override fun bite() {
        print("사과 톡톡 아삭")
    }
}

/** example03 - 2
 * - Apple을 열고(open) Apple을 상속받는다.
 */
class GreenApple2 : Apple() {
    override val color: String
        get() = "초록색"
}

/** example03 - 3 : 상속보단 합성
 * - 2번 방식보다 코드 양이 늘어난 단점이 있다.
 */
class GreenApple3(
    private val apple: Apple
) : Fruit {
    override val name: String
        get() = apple.name
    override val color: String
        get() = "초록색"

    override fun bite() = apple.bite()
}

/** example03 - 4 : 클래스 위임
 */
class GreenApple4(
    private val apple: Apple
) : Fruit by apple {
    override val color: String
        get() = "초록색"

}