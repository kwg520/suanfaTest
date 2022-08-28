package com.company.LinkList;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 *
 */

public class PublicNode {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode w1 = new ListNode(4);
        ListNode w2 = new ListNode(5);
        ListNode w3 = new ListNode(7);
        ListNode w4 = new ListNode(8);

        w1.next = w2;
        w2.next = w3;
        w3.next = w4;

        ListNode intersectionNode = getIntersectionNode(n1, w1);


    }


    //利用hashset

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    //利用走的步长的都是一样的
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
      if(headA==null  || headB == null){
          return null;
      }
      ListNode tempA = headA ,temB = headB;
      while (tempA!= temB){
          tempA = tempA == null ?  headB : tempA.next ;
          temB= temB == null ?  headA : temB.next ;
      }

      return tempA;

    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
