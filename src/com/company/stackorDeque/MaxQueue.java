package com.company.stackorDeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//public class MaxQueue {
//    int [] q = new int[20000];
//    int begin = 0 ,end = 0 ;
//    public MaxQueue() {
//
//    }
//
//    public int max_value() {
//        int ans = -1 ;
//        for(int i = begin ; i != end ; ++i){
//            ans = Math.max(ans,q[i]);
//        }
//        return ans ;
//    }
//
//    public void push_back(int value) {
//         q[end++] = value ;
//    }
//
//    public int pop_front() {
//         if(begin == end){
//             return  -1 ;
//         }
//         return  q[begin++];
//    }
//}

public class MaxQueue {
//一个 que 和一个 辅助  deque  ,deque每次添加元素 ，判断 里面有没有比他小的，有就出队列

    Queue<Integer> q;
    Deque<Integer> d;

    public MaxQueue() {
        q = new LinkedList<>();
        d = new LinkedList<>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peek();
    }

    public void push_back(int value) {
        q.add(value);
        while (!d.isEmpty() && d.peekLast()< value) {
            d.removeLast();//取队尾元素并删除
        }
        d.add(value);//添加元素到队尾

    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peek()) {
            d.poll();
        }
        return ans;
    }
}


