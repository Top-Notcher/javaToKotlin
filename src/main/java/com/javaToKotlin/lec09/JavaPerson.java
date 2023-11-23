package com.javaToKotlin.lec09;

public class JavaPerson {

    private final String name;
    private int age;

    // 2. 클래스가 생성되는 시점에 나이를 검증해보자.
    public JavaPerson(String name, int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(String.format("나이는 %s일 수 없습니다", age));
        }
        this.name = name;
        this.age = age;
    }

    // 3. 추가 생성자
    public JavaPerson(String name) {
        this(name, 1);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 4.
    public boolean isAdult() {
        return this.age >= 20;
    }

}

