package com.advanced.lec16;

public class MainJava {
    public static void main(String[] args) {
        // 1. 익명 클래스
        StringFilter filter = new StringFilter() {
            @Override
            public boolean predicate(String str) {
                return str.startsWith("A");
            }
        };


        // 2. 람다
        StringFilter filter2 = s -> s.startsWith("A");
    }
}
