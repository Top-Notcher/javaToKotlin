package com.javaToKotlin.lec12

import com.javaToKotlin.lec12.java.Movable

fun main() {
    moveSomething(object : Movable {
        override fun move() {
            println("움직인다~~")
        }

        override fun fly() {
            println("난다~~")
        }

    })
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}