package com.letv.jvm.controller;

import java.util.Iterator;

public class ClearTest implements Iterable<String>{
    String s;
    int index = 0;
    public static void main(String[] args) {
        for (String value : new ClearTest("123456789"))
            System.out.print(value+",");
    }

    @Override
    public Iterator<String> iterator() {
        char[] chars = s.toCharArray();
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return index++ < chars.length;
            }

            @Override
            public String next() {
                return chars[index-1]+"";
            }
        };
    }
    public ClearTest(String s){
        this.s = s;
    }
}
