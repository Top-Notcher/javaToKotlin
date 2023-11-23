package com.javaToKotlin.lec12.java;

public abstract class StringUtils {

    private StringUtils() {}

    public static boolean isDirectoryPath(String path) {
        return path.endsWith("/");
    }

}
