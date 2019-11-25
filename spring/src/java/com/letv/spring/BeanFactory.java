package com.letv.spring;

import org.apache.commons.lang.StringUtils;

public class BeanFactory {

    public static void main(String[] args) {
        String a = "1";
        String b = "a={a}";
        System.out.println(StringUtils.replace(b, "{a}" , a));
        System.out.println(String.format(b, a));
    }

}
