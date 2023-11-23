package com.javaToKotlin.lec02

import java.lang.IllegalArgumentException

fun main() {

    val str: String? = null
    println(str?.length ?: 0)

    println(startsWith(null))   // 런타임에서 npe

    val person = Person("공부하는 개발자")
    startsWithPerson(person.name)
}

fun startsWithPerson(str: String): Boolean {
    return str.startsWith("A")
}

fun startsWithA1(str: String?) : Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어왔습니다")

//    if(str == null) {
//        throw IllegalArgumentException("null이 들어왔습니다")
//    }
//    return str.startsWith("A")
}

fun startsWithA2(str: String?) : Boolean? {
    return str?.startsWith("A")
//    if(str == null) {
//        return null
//    }
//    return str.startsWith("A")
}

fun startWithA3(str: String?) : Boolean {
    return str?.startsWith("A") ?: false
//    if(str == null) {
//        return false
//    }
//     return str.startsWith("A");
}

fun startsWith(str: String?): Boolean {
    return str!!.startsWith("A")
}