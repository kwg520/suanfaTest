package com.company.LinkList;

import java.util.Stack;

/**
 * 链表反转
 */
public class ReverseLinkList {
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
//        reverseLinkList(n1);//通过指针迭代


        ListNode listNode = reverseLinkList2(n1);//通过栈
        listOfNode(listNode);

//        Stack<Integer> stack =  new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        while (stack.pop()!= null){
//            System.out.println(stack.pop());
//        }


    }

    private static void listOfNode(ListNode listNode) {
        ListNode current = listNode;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    private static ListNode reverseLinkList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = null;
            stack.push(current);
            current = next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode nHead = stack.pop();
        ListNode temp = nHead;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        return nHead;

    }

    private static ListNode reverseLinkList(ListNode head) {
        ListNode pre = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = next;
        }
        return pre;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
