package com.lannstark.lec10.Java;

public interface JavaSwimable {

    default void act() {
        System.out.println("어푸 어푸");
    }

}
