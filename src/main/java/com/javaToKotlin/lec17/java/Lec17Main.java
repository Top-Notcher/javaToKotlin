package com.javaToKotlin.lec17.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lec17Main {

    public static void main(String[] args) {
        List<Fruit> fruits = Arrays.asList(
                new Fruit("사과", 1_000),
                new Fruit("사과", 1_200),
                new Fruit("사과", 1_200),
                new Fruit("사과", 1_500),
                new Fruit("바나나", 3_000),
                new Fruit("바나나", 3_200),
                new Fruit("바나나", 2_500),
                new Fruit("수박", 10_000)
        );

        filterFruits(fruits, fruit -> fruit.getName().equals("사과"));
        filterFruits(fruits, Fruit::isApple);

        String targetFruitName = "바나나";
        targetFruitName = "수박";
//        filterFruits(fruits, (fruit) -> targetFruitName.equals(fruit.getName()));
        // Variable used in lambda expression should be final or effectively final
    }

    private static List<Fruit> filterFruits(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
//        List<Fruit> results = new ArrayList<>();
//        for (Fruit fruit : fruits) {
//            if (fruitFilter.test(fruit)) {
//                results.add(fruit);
//            }
//        }
//        return results;

        return fruits.stream()
                .filter(fruitFilter)
                .collect(Collectors.toList());
    }

}
