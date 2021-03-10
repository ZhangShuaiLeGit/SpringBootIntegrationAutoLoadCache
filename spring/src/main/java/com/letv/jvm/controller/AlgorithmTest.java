package com.letv.jvm.controller;

import java.util.*;

/**
 * 1、数组合并int[] arr1 = new int[]{3,2,4,1,6,5,7}; int[] arr2 = new int[]{1,2,3,4,5,6,7};
 * 2、数组去重
 * 3、数组作栈
 * 4、根据前序遍历及中序遍历重建二叉树
 * 5、数组返回给定值
 * 6、快速排序
 * 7、链表反转
 * 8、我努力了，期待结果
 */
public class AlgorithmTest{

    public static int maxLength (int[] arr) {
//         write code here
        if (null == arr || arr.length < 0) {
            return 0;
        }
        int[] resultArray = new int[100000];
        int start = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            start = Math.max(start, resultArray[index]);
            result = Math.max(result, i - start +1);
            resultArray[index] = i + 1;
        }
//        Collections.reverse();
        return result;
    }

    public static void main(String[] args) {
//        int[] arr1 = new int[]{3,2,4,1,6,5,7,8}; int[] arr2 = new int[]{1,2,3,4,5,6,7};
//        Iterable;
//        Iterator;
//        Integer[] arr = {1,2,3,4,5};
//        char[] chars = "".toCharArray();
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr)) ;
//        System.out.println(list);
//        int q1 = 0,q2 = 1;
//        for (int i = 0,end = arr1.length; i < end;) {
//            while (arr1[q1] % 2 == 1) {
//                int temp = arr1[q1];
//                arr1[q1] = arr1[q2];
//                arr1[q2] = temp;
//                q2 += 2;
//            }
//            q1 += 2;
//            i += 2;
//        }
//        System.out.println(Arrays.toString(arr1));

//        int[] arr = new int[arr1.length+arr2.length];
//        System.arraycopy(arr1, 0, arr, 0, arr1.length);
//        System.arraycopy(arr2, 0, arr1, arr1.length-arr2.length, arr2.length);
//        Arrays.sort(arr1);
//        System.out.println(Arrays.toString(arr1));
//        List<Integer> list = new ArrayList<>(arr.length);
//        for (int i: arr){
//            if (!list.contains(i)){
//                list.add(i);
//            }
//        }
//        Object[] arr3= list.toArray();
//        System.out.println(Arrays.toString(arr3));
//        MyStack myStack = new MyStack();
//        myStack.push(1);
//        myStack.push(2);
//        myStack.push(3);
//        myStack.print();
//        System.out.println(myStack.pop());
//        myStack.print();
//        System.out.println(myStack.pop());
//        TreeNode treeNode = reBuildBalanceTree(arr2, arr1);

//        System.out.println(JumpFloor(4));
//        fun(arr2, 9);
//        quickSort(arr1, 0, arr1.length-1);
//        System.out.println(Arrays.toString(arr1));
    }


    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(head == null|| head.next == null || k<2){
            return head;
        }
        //构造一个新的头节点，方便返回值时找到反转后链表的头节点。
        ListNode preNode = new ListNode(0);
        preNode.next = head;
        ListNode pre = preNode ,cur = head, tmp = null ;
        int len = 0;

        while(head!=null){
            ++len;
            head = head.next;
        }

        for(int i = 0 ; i < len/k ;i++){
            for(int j = 1 ; j < k ; j++){
                tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }
            pre = cur;
            cur = cur.next;
        }

        return preNode.next;
    }

    public Node fun(Node node) {
        if (node == null || node.next == null)
            return node;
        Node temp = node.next;
        Node newNode = fun(node);
        temp.next = node;
        newNode.next = null;
        return newNode;
    }

    private static void quickSort(int[] arr1, int low, int high) {
        if (arr1 == null || arr1.length == 0)
            return;
        if (low < high) {
            int index = getIndex(arr1, low, high);
            quickSort(arr1, low, index-1);
            quickSort(arr1, index+1, high);
        }
    }

    private static int getIndex(int[] arr1, int low, int high) {
        int temp = arr1[low];
        while (low < high){
            while (low < high && arr1[high] >= temp)
                high--;
            arr1[low] = arr1[high];
            while (low < high && arr1[low] <= temp)
                low++;
            arr1[high] = arr1[low];
        }
        arr1[low] = temp;
        return low;
    }

    private static void fun(int[] arr2, int i) {
        if (arr2 == null || arr2.length == 0)
            return;
        for (int j = 0,end = arr2.length; j < end; j++) {
            for (int k = j+1; k < end; k++) {
                if (arr2[j] + arr2[k] == i) {
                    System.out.println(Arrays.toString(new int[]{arr2[j], arr2[k]}));
                    return; //不加就是全部符合
                }
            }
        }
    }

    private static TreeNode reBuildBalanceTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0)
            return null;

        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0,end = in.length; i < end; i++) {
            if (treeNode.val == in[i]){
                treeNode.left = reBuildBalanceTree(Arrays.copyOfRange(pre, 1,i+1), Arrays.copyOfRange(in, 0,i));
                treeNode.right = reBuildBalanceTree(Arrays.copyOfRange(pre, i+1,pre.length), Arrays.copyOfRange(in, i+1,in.length));
            }
        }
        return treeNode;
    }

    public static int JumpFloor(int target) {
        if (target == 0)
            return 0;
        else if (target == 1)
            return 1;
        else if (target == 2)
            return 2;
        return JumpFloor(target -1) + JumpFloor(target -2);
    }

}
class MyStack {

    private Object[] arr;
    private int size;

    MyStack(){
        arr = new Object[]{};
        size = 0;
    }

    void push(Object o){
        save(++size, true);
        arr[size-1] = o;
    }

    Object pop(){
        try {
            return arr[size-1];
        } finally {
            save(--size, false);
        }
    }

    private void save(int newSize, boolean b){
        Object[] temp = new Object[newSize];
        if (b){
            System.arraycopy(arr, 0, temp, 0, arr.length);
        } else {
            System.arraycopy(arr, 0, temp, 0, newSize);
        }
        arr = temp;
    }

    public void print(){
        System.out.println(Arrays.toString(arr));
    }
}
class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

