package com.lannstark.lec15.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lec15Main {

    public static void main(String[] args) {

        // 1. 배열
        int[] array = {100, 200};
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s %s", i, array[i]);
        }

        // 2. List
        final List<Integer> numbers = Arrays.asList(100, 200);

        // 하나 가져오기
        System.out.println(numbers.get(0));

        // For Each
        for (int number : numbers) {
            System.out.println(number);
        }

        // 전통적인 For문
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("$s $s", i, numbers.get(i));
        }

        // 3. Set
        // 4. Map
        // JDK 8까지
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "MONDAY");
        map.put(2, "TUESDAY");

        // JDK 9부터
        Map.of(1, "MONDAY", 2, "TUESDAY");

        for (int key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

}
