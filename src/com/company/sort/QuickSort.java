package com.company.sort;

import java.util.Arrays;

/**
 * 给定一个基准数，从头找比他大的 ，从尾部找比他小的，交换位置，再继续移动，直到 头指针 和 尾指针 相遇，则交换当前位置和基准数
 */
public class QuickSort {

    public static void main(String[] args) {
        int arr[]  = new int[]{90,-7,13,9,20,-9,50,7};
        quickSort(0,arr.length-1,arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int start, int end, int[] arr) {
        int i = start ;
        int j = end ;
        int pvoit = arr[i];
        while (i< j){
            while ((i<j) && (arr[j]>pvoit)){
                j--;
            }
            while ((i<j) && (arr[i] < pvoit)){
                i++ ;
            }
            if(arr[i] == arr[j] && (i<j)){
                i++;
            }else {
                int temp = arr[i];
                arr[i]  = arr[j] ;
                arr[j]  = temp ;
            }
        }
        if((i-1)>start){
            quickSort(start,i-1,arr);
        }
        if(j+1<end){
            quickSort(j+1,end,arr);
        }

    }
}
