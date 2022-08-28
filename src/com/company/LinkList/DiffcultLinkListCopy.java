package com.company.LinkList;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DiffcultLinkListCopy {

   static   class Solution {
        Map<Node,Node> map = new HashMap<Node,Node>();
        public Node copyRandomList(Node head) {
            if(head==null){
                return null ;
            }
            if(!map.containsKey(head)){
                Node headnew = new Node(head.val);
                map.put(head,headnew);
                headnew.next = copyRandomList(head.next);
                headnew.random = copyRandomList(head.random);
            }
            return map.get(head);
        }
    }



   static   class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
