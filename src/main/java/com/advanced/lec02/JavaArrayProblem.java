package com.advanced.lec02;

import java.util.List;

public class JavaArrayProblem {
    public static void main(String[] args) {

        // Java 배열의 공변 문제점
        String[] strs = new String[]{"A", "B", "C"};
        Object[] objs = strs;
        objs[0] = 1;    // java.lang.ArrayStoreException: java.lang.Integer

        /** desc
         * objs는 사실 String[]이기 때문에 int를 넣을 수 없다.
         * 때문에 런타임 때 에러가 발생한다. -> 타입-안전하지 않아 위험한 코드이다!
         */


        // Java의 리스트는 불공변하다
        List<String> strList = List.of("A", "B", "C");
        // Type Mismatch! -> 컴파일 에러
//        List<Object> objectList = strs;

        /** desc
         * Effective Java Item28. 배열보다는 리스트를 사용하라.
         */

    }
}
