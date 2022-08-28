package com.company.LinkList;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 删除链表倒数第n个结点，并返回头结点
 */
public class deleteNLinkList {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode listNode = removeNthFromEnd(n1, 2);
        listOfNode(listNode);


    }

    private static void listOfNode(ListNode listNode) {
        ListNode current = listNode;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode curNode = dump;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return dump.next;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
