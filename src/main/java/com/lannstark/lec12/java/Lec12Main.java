package com.lannstark.lec12.java;

import com.lannstark.lec12.Person;

public class Lec12Main {

    public static void main(String[] args) {
        // Person.Companion.newBaby("ABC");  // 이름이 없을때
        // Person.newBaby("ABC");            // @JvmStatic 사용시
        // Person.Factory.newBaby("ABC");    // 이름 존재 시

        moveSomething(new Movable() {

            @Override
            public void move() {
                System.out.println("움직인다~~");
            }

            @Override
            public void fly() {
                System.out.println("난다~~");
            }
        });
    }

    private static void moveSomething(Movable movable) {
        movable.move();
        movable.fly();
    }

}
