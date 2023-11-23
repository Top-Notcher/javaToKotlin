package com.javaToKotlin.lec08;

public class Lec08Main {

    public static void main(String[] args) {

    }

    // 1. 두 정수를 받아 더 큰 정수를 반환하는 예제
    public int max(int a, int b) {
        if(a > b) {
            return a;
        }
        return b;
    }

    // 2. 주어진 문자열을 N번 출력하는 예제
    public void repeat(String str, int num, boolean useNewLine) {
        for (int i = 1; i <= num; i++) {
            if(useNewLine) {
                System.out.println(str);
            }else {
                System.out.println(str);
            }
        }
    }

    // Java의 오버로딩(OverLoading) 활용!
    public void repeat(String str, int num) {
        repeat(str, num, true);
    }
    public void repear(String str) {
        repeat(str, 3, true);
    }

    // 4. 같은 타입의 여러 파라미터 받기 (가변 인자)
    public static void printAll(String... strings) {
        for (String str : strings) {
            System.out.println(str);
        }
    }

}
