package com.letv.jvm.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaTest {

    @FunctionalInterface//“函数式接口”是指仅仅只包含一个抽象方法的接口
    interface Test{
        String saySomeThing(String s);
    }

    @FunctionalInterface//“函数式接口”是指仅仅只包含一个抽象方法的接口
    interface Test1{
        void saySomeThing();
    }

    @FunctionalInterface//“函数式接口”是指仅仅只包含一个抽象方法的接口
    interface Test2{
        void saySomeThing(String a, String b);
    }
    @FunctionalInterface//“函数式接口”是指仅仅只包含一个抽象方法的接口
    interface Test3{
        int saySomeThing(int a, int b);
    }
    @FunctionalInterface//“函数式接口”是指仅仅只包含一个抽象方法的接口
    interface Test4{
        void saySomeThing(String s);
    }
    @FunctionalInterface//“函数式接口”是指仅仅只包含一个抽象方法的接口
    interface Test5{
        boolean saySomeThing(String s);
    }
    @FunctionalInterface//“函数式接口”是指仅仅只包含一个抽象方法的接口
    interface Test6{
        boolean saySomeThing(String s,String s1);
    }
    @FunctionalInterface//“函数式接口”是指仅仅只包含一个抽象方法的接口
    interface Test7{
        void saySomeThing(String s,String s1,String s2,String s3,String s4,String s5,String s6);
    }

//    public static void main(String[] args) {
////        int[] arr = {1,2,3};
////        Arrays.asList(arr).forEach(s -> System.out.println(s));
////        new Thread(new Runnable() {
////            @Override
////            public void run() {
////
////            }
////        });
//
//
//        Test test = s -> s.split("-")[0];
//        Test1 test1 = () -> System.out.println("你好");
//        Test2 test2 = (s, s1) -> System.out.println(s + s1);
//        Test3 test3 = (a, b) -> a + b;
//        Test4 test4 = System.out::println;
//        Test5 test5 = s -> s.equals("你");
//        Test6 test6 = (s1, s2) -> s1.equals(s2);
//        BiPredicate<String, String> saySomeThing11 = (s1, s2) -> s1.startsWith(s2);
//
//        BiFunction<Test, String, String> saySomeThing1 = Test::saySomeThing;//  有返回值
//        Consumer<Test1> saySomeThing = Test1::saySomeThing;//   无返回值
//        Function<Person, String> getName = Person::getName;//   有返回值
//        BiConsumer<Person, String> setName = Person::setName;
//        Consumer3<Test2, String, String> saySomeThing2 = Test2::saySomeThing;//   无返回值
//        Function3<Test3, Integer, Integer, Integer> saySomeThing3 = Test3::saySomeThing;//   有返回值
//        Function3<Test3, Integer, Integer, Integer> saySomeThing10 = Test3::saySomeThing;//   有返回值
//        BiConsumer<Test4, String> saySomeThing4 = Test4::saySomeThing;//   无返回值
//        BiFunction<Test5, String, Boolean> saySomeThing5 = Test5::saySomeThing;
//        BiPredicate<Test5, String> saySomeThing9 = Test5::saySomeThing;
//        Function3<Test6, String, String, Boolean> saySomeThing6 = Test6::saySomeThing;
//        BiPredicate<String, String> saySomeThing7 = String::equals;
//        System.out.println(saySomeThing7.test("1", "1"));
//        Predicate3<Test6, String, String> saySomeThing8 = Test6::saySomeThing;
//        System.out.println(saySomeThing8.test(test6, "A", "A"));
//        saySomeThing11.or(String::startsWith);
//        Person p = new Person();
//        p.setName("张三");
//        ArrayList list = new ArrayList();
//        Optional<Person> opt = Optional.ofNullable(p);
//        Optional<String> s1 = Optional.ofNullable("张三");
//        BiFunction<ArrayList, Person, Boolean> arrayListEBooleanBiFunction = ArrayList<Person>::add;
//        arrayListEBooleanBiFunction.apply(list, p);
//
////        list.stream().map(person -> person.getName().equal("张三"));
////        opt.map().ifPresent(System.out::println);
//        String s = opt.map(person -> person.getName()).orElse("李四");
//        System.out.println(s);
//        Stream<Integer> integerStream = Stream.of(1, null, 3);
//        long count = integerStream.count();
//        System.out.println(count);
//        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
//        Integer reduce = nums.stream().filter(num -> num != null).reduce((sum, item) -> sum + item).get();
//        System.out.println(reduce);
//
////        System.err.println("sum is:"+nums.stream().
////                filter(num -> num != null).
////                distinct().
////                mapToInt(num -> num * 2).
////                peek(System.err::println).
////                skip(2).
////                limit(4).
////                sum());
//
////        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
////        List<Integer> numsWithoutNull1 = nums.stream().filter(num -> num != null).collect(Collectors.toList());
////        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).collect(() -> new ArrayList<Integer>(),
////                (list1, item) -> list1.add(item),(list1, list2) -> list1.addAll(list2));
////        List<Integer> collect = nums.stream().filter(num -> num != null).map(num -> sun(num)).collect(Collectors.toList());
////        System.out.println(Arrays.toString(numsWithoutNull.toArray()));
////        System.out.println(Arrays.toString(numsWithoutNull1.toArray()));
////        System.out.println(Arrays.toString(collect.toArray()));
//
////        System.out.println(test.saySomeThing("213-1"));
////        System.out.println(saySomeThing1.apply(test, "asdas-a"));
////        saySomeThing.accept(test1);
////        saySomeThing2.accept(test2, "hello", "world");
////        System.out.println(saySomeThing3.apply(test3, 1, 2));
////        System.out.println(getName.apply(new Person()));
//    }

    static int sun(int num) {
        if ( num % 2 == 0)
            return num;
        return 0;
    }

    public static void main(String[] args) {
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        reorderList(node);
//        System.out.println(Arrays.toString(reOrderArray(new int[]{1,2,3,4})));
//        HttpServletRequest
//        MergedBeanDefinitionPostProcessor;
//        InitializingBean;
//        AutowiredAnnotationBeanPostProcessor;
//        ConcurrentHashMap;
//        ThreadLocal<>;
//        Executors.newCachedThreadPool()

        int[] arr = {1, 5, 6, 4, 9, 8};

        System.out.println(fun(arr, 2));
    }

    public static int fun (int[] array,int k) {

        Integer[] temp = Arrays.stream(array).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Comparator.reverseOrder());
        return Arrays.stream(temp)
                .skip(k-1)
                .collect(Collectors.toList())
                .get(0);
//        Integer[] integers = Arrays.stream(array).boxed().toArray(Integer[]::new);
//        Arrays.sort(integers, Comparator.reverseOrder());
//        return Arrays.stream(integers).skip(k-1).collect(Collectors.toList()).get(0);
    }

    public static int[] reOrderArray (int[] array) {
        // write code here
        if (array == null)
            return null;
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        for (int a : array){
            if (a % 2 == 1)
                array1.add(a);
            else
                array2.add(a);
        }
        System.arraycopy(array1.toArray(), 0, array, 0, array1.size());
        System.arraycopy(array2.toArray(), 0, array, array1.size(), array2.size());
        return array;
    }

    public static void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode slow = head,fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode after = slow.next;
        slow.next = null;// 保留前半段链
        ListNode pre = null;
        while (after != null){
            ListNode temp = after.next;
            after.next = pre;
            pre = after;
            after = temp;
        }
        ListNode first = head;
        after = pre;
        while(first != null && after != null){
            ListNode ftemp = first.next;
            ListNode aftemp = after.next;
            first.next = after;
            first = ftemp;
            after.next = ftemp;
            after = aftemp;
        }
    }

}
class Person{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}