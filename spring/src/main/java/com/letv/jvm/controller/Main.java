package com.letv.jvm.controller;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 */

public class Main {

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5,6,7};
        int[] arr = new int[]{3, 2, 4, 1, 6, 5, 7};
//        Test1.test();
//        PriorityQueue
        System.out.println((1 & 4));
        Iterable it = new HashMap<>().entrySet();
        it.iterator().next();
        new Thread(() -> System.out.println(1)).start();
        FutureTask<Integer> future = new FutureTask<Integer>(() -> {
            int a = 5;
            a++;
            return a;
        });
//        quickSort(arr, 0, arr.length-1);
        new Thread(future, "有返回值的线程").start();//实质上还是以Callable对象来创建并启动线程
        try {
            System.out.println("子线程的返回值：" + future.get());//get()方法会阻塞，直到子线程执行结束才返回
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(arr).contains("5"));
        System.out.println(Arrays.toString(arr));

    }
    public int flag = 0, flag1 = 0, flag2 = 0;
    public int[][] threeOrders (TreeNode root) {
        // write code here
        int[][] nums = new int[3][getRootSize(root)];

        getOrder(root, nums);
        return nums;
    }
    public void getOrder(TreeNode root, int[][] nums){
        if(root == null){return ;}
        nums[0][flag++] = root.val;
        getOrder(root.left, nums);
        nums[1][flag1++] = root.val;
        getOrder(root.right, nums);
        nums[2][flag2++] = root.val;
    }
    public int getRootSize(TreeNode root){
        if(root == null){return 0;}
        return 1 + getRootSize(root.left) + getRootSize(root.right);
    }

    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        return 1+Math.max(TreeDepth(root.left),TreeDepth(root.right));
    }


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);
            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            //quickSort(arr, 0, index - 1); 之前的版本，这种姿势有很大的性能问题，谢谢大家的建议
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    public static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[high];
        while (low < high) {
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp)
                low++;
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp)
                high--;
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }

    private static void test(String s) {
        s += "1";
    }

    static int[] twoSum(int [] arr, int target){
        if (arr == null || arr.length == 0)
            return new int[0];
        for (int i = 0,end = arr.length; i < end; i++){
            for (int j = i+1; j < end; j++){
                if(arr[i]+arr[j]==target){
                    return new int[]{arr[i],arr[j]};
                }
            }
        }
        return new int[0];
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0)
            return null;
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0,end = in.length; i < end; i++) {
            if (treeNode.val == in[i]) {
                treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1,i+1), Arrays.copyOfRange(in, 0,i));
                treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
            }
        }
        return treeNode;
    }
}
/*
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String s=sc.next();
            StringBuffer sb=new StringBuffer();
            for(int j=0;j<s.length();j++){
                if(sb.length()<2){
                    sb.append(s.charAt(j));
                    continue;
                }
                if(sb.length()>=2){
                    if(s.charAt(j)==sb.charAt(sb.length()-1) &&s.charAt(j)==sb.charAt(sb.length()-2))
                        continue;

                }
                if(sb.length()>=3){
                    if(s.charAt(j)==sb.charAt(sb.length()-1) &&sb.charAt(sb.length()-3)==sb.charAt(sb.length()-2))
                        continue;
                }
                sb.append(s.charAt(j));
            }
            System.out.println(sb.toString());
        }
 */
//interface Test1{
//    public int a = 1;
//    public void test(){
//        System.out.println(1);
//    }
//}


class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}