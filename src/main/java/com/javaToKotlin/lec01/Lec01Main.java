package com.javaToKotlin.lec01;

import java.util.ArrayList;
import java.util.List;

public class Lec01Main {

    public static void main(String[] args) {
        long number1 = 10L;         // (1)
        final long number2 = 10L;   // (2)

        Long number3 = 1_000L;      // (3)
        Person person = new Person("박현민"); // (4)

        final List<Integer> numbers = new ArrayList<>();  // collection 자체는 바꾸지 못하지만 값 추가 가능
        numbers.add(3);
    }

}
