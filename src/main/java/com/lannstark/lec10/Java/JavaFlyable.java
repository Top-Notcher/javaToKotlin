package com.lannstark.lec10.Java;

public interface JavaFlyable {

    default void act() {
        System.out.println("파닥 파닥");
    }


}
