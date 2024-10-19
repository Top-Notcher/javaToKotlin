package com.advanced.lec08;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public class LateinitPrinciple {

    /**
     * lateinit 코드를 컴파일 시 Java 코드
     */
    public final class Person {
        public String name;

        @NotNull
        public final String getName() {
            String var10000 = this.name;
            if (var10000 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("name");
            }

            return var10000;
        }


    }
}
