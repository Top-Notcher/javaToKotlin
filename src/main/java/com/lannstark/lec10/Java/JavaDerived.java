package com.lannstark.lec10.Java;

public class JavaDerived extends JavaBase {

    public JavaDerived() {
        super();
    }

    @Override
    public int getMember() {
        return 10;
    }

    public static class Lec10Main {

        public static void main(String[] args) {
            new JavaDerived();
        }

    }
}
