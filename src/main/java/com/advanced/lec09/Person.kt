package com.advanced.lec09

import kotlin.reflect.KProperty


/** before : backing property
 */
class Person1 {
    // name과 대응되는 외부로 드러나지 않는 프로퍼티 : backing property
    private var _name: String? = null
    val name: String
        get() {
            if (_name == null) {
                Thread.sleep(2_000)
                this._name = "김수한무"
            }
            return _name!!
        }
}

/** after : 위임 패턴
 * - by lazy 역시 완전히 동일한 원리이다!
 */
class Person2 {
    val delegateProperty = LazyInitProperty1 {
        Thread.sleep(2_000L)
        "김수한무"
    }

    val name: String
        get() = delegateProperty.value
}

class LazyInitProperty1<T>(val init: () -> T) {
    private var _value: T? = null
    val value: T
        get() {
            if (_value == null) {
                this._value = init()
            }
            return _value!!
        }

}

/** example02 : by lazy
 */
class Person3 {
    val name: String by lazy {
        Thread.sleep(2_000)
        "김수한무"
    }
}

class Person4 {
    val name: String by LazyInitProperty2 {
        Thread.sleep(2_000)
        "김수한무"
    }
}

class LazyInitProperty2<T>(val init: () -> T) {
    private var _value: T? = null
    private val value: T
        get() {
            if (_value == null) {
                this._value = init()
            }
            return _value!!
        }

    operator fun getValue(thisRef: Any, property: KProperty<*>): T {
        return value
    }
}