package com.yang.gateway.util;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = str -> str.equals("zhangsan");
        predicate.test("zhangsan");
    }
}
