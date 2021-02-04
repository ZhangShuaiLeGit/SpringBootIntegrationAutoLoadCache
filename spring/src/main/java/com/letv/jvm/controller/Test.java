package com.letv.jvm.controller;

/**
 * logback.xml加载早于application.properties，所以如果你在logback.xml使用了变量时，
 * 而这个变量是写在application.properties时，那么就会获取不到，只要改成logback-spring.xml就可以解决。
 */

public class Test {
    public static void main(String[] args) {
        char a = ' ';
        System.out.println((int)a);
    }
}
