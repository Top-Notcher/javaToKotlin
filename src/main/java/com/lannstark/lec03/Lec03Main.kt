package com.lannstark.lec03

fun main() {
    val number1 = 3
    val number2: Long = number1.toLong()

    val number3: Int? = 3
    val number4: Long = number3?.toLong() ?: 0L

    printAgeIfPerson2(null) //NPE

    val person = Person("박현민", 27)
    System.out.println(String.format("이름 : %s", person.name))
    println("이름 : ${person.name}")

    val name = "박현민"
    println("이름 : $name")

    val str = """
        ABC        
        
    """.trimIndent()
    println(str)

    val str2 = "ABCDE"
    val ch = str[1]
}

fun printAgeIfPerson(obj: Any) {
    if(obj is Person) {                     // 반대 : !is
        println(obj.age)    // 스마트 캐스트
//        val person = obj as Person
//        println(person.age)
    }
}

fun printAgeIfPerson2(obj: Any?) {
//    val person = obj as Person
//    println(person.age)

    val person: Person? = obj as? Person     // null 이 아니면 Person 타입으로 변경, null이라면 null
    println(person?.age)
}