package com.company.LinkList;


import java.util.*;

/**
 * 打印链表用数组返回
 */
public class revsePrintLinkList {

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        int[] ints = reversePrint(n1);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] reversePrint(ListNode head) {
//        Deque<Integer> stack  = new ArrayDeque();
//        ListNode curNode = head ;
//        while(curNode!= null){
//            stack.addLast(curNode.val);
//            curNode = curNode.next ;
//        }
////         int size = stack.size();
//        int [] res = new int[stack.size()];
//        for(int i = 0 ;i< stack.size();i++){
//            System.out.println("===="+stack.size());
//            res[i] = stack.removeLast();
//        }
//        return res ;

        Stack<Integer> stack = new Stack<>();
        ListNode curNode = head;
        while (curNode != null) {
            stack.add(curNode.val);
            curNode = curNode.next;
        }
        int size = stack.size();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
