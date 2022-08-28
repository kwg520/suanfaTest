package com.company.stackorDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 双栈实现队列
 * 一个栈负责装入
 * 要删除的时候 把1栈的元素全部push到2栈来，再2栈pop一下
 */
public class CQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public CQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int value){
        inStack.push(value);
    }

    public int deleteHead(){
        if(outStack.isEmpty()){
            if(inStack.isEmpty()){
                return -1 ;
            }
            int2Out();
        }

        return outStack.pop();
    }

    private void int2Out() {
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
}
