package com.advanced.lec20

@Repeatable
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Shape(
    val text: String,
    val number: Int,
//    val clazz: KClass<*>
    val texts: Array<String>
)


//@Shape(text = "ㅎㅇㅎㅇ111", number = 2, ["B"])
@Shape(text = "ㅎㅇㅎㅇ", number = 1, ["A", "B"])
class Hello

