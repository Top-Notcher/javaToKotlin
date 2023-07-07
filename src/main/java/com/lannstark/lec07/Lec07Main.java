package com.lannstark.lec07;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lec07Main {

    //1. 주어진 문자열을 정수로 변경하는 예제
    private int parseIntOrThrow(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("주어진 %s는 숫자가 아닙니다.", str));
        }
    }

    //2. 주어진 문자열을 정수로 변경하는 예제, 실패하면 null을 반환!
    private Integer parseIntOrThrowV2(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        }catch (NumberFormatException e) {
            return null;
        }
    }

    //3. 프로젝트 내 파일의 내용물을 읽어오는 예제
    public static void main(String[] args) throws IOException {
        JavaFilePrinter printer = new JavaFilePrinter();
        printer.readFile();
    }

}
