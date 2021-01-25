package com.letv.jvm.controller;

import com.google.common.collect.ImmutableMap;

import java.util.*;
import java.util.function.BiFunction;

public class TestJvm {

    public static void main(String[] args) {
//        Map<String, List<Object>> menu = new ImmutableMap.Builder<String, List<Object>>().put("as", null).build();
        int count = 0;
        System.out.println(count++);
        System.out.println(count++);
        System.out.println(count++);
//        System.out.println(menu.get("as"));
    }

}
enum Operation{

    ADD((x, y) -> x + y),
    SUBTRACT((x, y) -> x - y);

    Operation(BiFunction<Integer, Integer, Integer> operation){
        this.operation = operation;
    }

    private BiFunction<Integer, Integer, Integer> operation;

    public Integer apply(Integer x, Integer y){
        return operation.apply(x, y);
    }
}
class Other implements BiFunction<Integer, Integer, Integer>{

    @Override
    public Integer apply(Integer integer, Integer integer2) {
        return null;
    }
}