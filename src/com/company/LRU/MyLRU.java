package com.company.LRU;

import sun.misc.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最近最少使用 ,缓存技术
 * get  put
 * capacity
 */
public class MyLRU extends LinkedHashMap<Integer,Integer> {

    private int capacity;
    public MyLRU(int capacity){
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public  int get(int key){
        return super.getOrDefault(key,-1);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        MyLRU lru = new MyLRU(3);

        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        System.out.println(lru.keySet());

        lru.put(4, 1);
        System.out.println(lru.keySet());

        lru.put(3, 1);
        System.out.println(lru.keySet());
        lru.put(3, 1);
        System.out.println(lru.keySet());
        lru.put(3, 1);
        System.out.println(lru.keySet());

        lru.put(5, 1);
        System.out.println(lru.keySet());
    }
}
