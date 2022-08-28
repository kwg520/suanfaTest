package com.company.LRU;

import java.util.HashMap;
import java.util.Map;

public class MyLRU2 {


    class Node<K, V> {
        K key;
        V value;
        Node<K, V> pre;
        Node<K, V> next;

        public Node() {
            this.pre = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.pre = this.next = null;
        }
    }

    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.pre = head;
        }

        //添加到头
        public void addHead(Node<K, V> node) {
//            node.next = head.next;
//            node.pre = head;
//            head.next = node;
//            head.next.pre = node;

            node.next = head.next;
            node.pre = head;
            head.next.pre = node;//注意添加顺序
            head.next = node;
        }


        //删除节点
        public void removeNode(Node<K, V> node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.pre = null;
            node.next = null;
        }

        //活动的最后一个节点
        public Node getLast() {
            return tail.pre;
        }


    }


    private int cacheSize;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public MyLRU2(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new HashMap<>();
        this.doubleLinkedList = new DoubleLinkedList<>();
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);

        } else {
            if (map.size() == cacheSize) {
                Node lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key, newNode);
            doubleLinkedList.addHead(newNode);
        }

    }

    public static void main(String[] args) {
        MyLRU2 lru2 = new MyLRU2(3);
        lru2.put(1, 1);
        lru2.put(2, 2);
        lru2.put(3, 3);
        System.out.println(lru2.map.keySet());

        lru2.put(4, 1);
        System.out.println(lru2.map.keySet());

        lru2.put(3, 1);
        System.out.println(lru2.map.keySet());
        lru2.put(3, 1);
        System.out.println(lru2.map.keySet());
        lru2.put(3, 1);
        System.out.println(lru2.map.keySet());

        lru2.put(5, 1);
        System.out.println(lru2.map.keySet());
    }


}
