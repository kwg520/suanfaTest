package com.company.divideandconquer;

/**
 * 分治算法实现汉诺塔
 *
 */
public class Hanoitower {

    public static void main(String[] args) {

        hannoTower(12,'A','B','C');//a-b a-c  b-c
    }

    public static void hannoTower(int num ,char a, char b ,char c ){
        //如果只有一个盘
        if(num==1){
            System.out.println("第一个盘从"+ a  + "->" + c);
        }else {
            //如果我们有n>= 2 情况，我们总可以看作两个盘 1.最下面的一个盘， 2 ，上面的所有盘
            //1。先把最上面的所有盘 A-> B ,移动过程中使用到的C
            hannoTower(num-1,a,c,b);
            //2.把下面的盘 A -> C
            System.out.println("第"+num +"个盘从" + a + "->" +c);
            //3.把B塔的所有盘 B->C ，移动过程中使用到的a
            hannoTower(num-1,b,a,c);
        }
    }
}
