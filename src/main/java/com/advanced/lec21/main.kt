package com.advanced.lec21

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.createType
import kotlin.reflect.full.hasAnnotation

/** example01
 * - 함수 executeAll(obj: Any)를 만든다.
 * - obj가 @Executable 어노테이션을 갖고 있으면, obj에서 파라미터가 없고 반환 타입이 Unit인 함수를 모두 실행한다.
 */

@Target(AnnotationTarget.CLASS)
annotation class Executable

@Executable
class Reflection {
    fun a() {
        println("A")
    }

    fun b(n: Int) {
        println("B")
    }
}

fun executeAll(obj: Any) {
    val kClass = obj::class
    if (!kClass.hasAnnotation<Executable>()) {
        return
    }

    val callableFunctions = kClass.members.filterIsInstance<KFunction<*>>()
        .filter { it.returnType == Unit::class.createType() }
        .filter { it.parameters.size == 1 && it.parameters[0].type == kClass.createType() }

    callableFunctions.forEach { function ->
        function.call(kClass.createInstance())
    }
}

fun main() {
    executeAll(Reflection())

    val kClass1: KClass<Reflection> = Reflection::class

    val ref = Reflection()
    val kClass2: KClass<out Reflection> = ref::class

    val KClass3: KClass<out Any> = Class.forName("com.advanced.lec21.Reflection").kotlin

    kClass1.java            // Class<Reflection>
    kClass1.java.kotlin     // KClass<Reflection>
}
