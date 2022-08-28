package com.company.binarySearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二分法递归和非递归的实现
 */
public class binarySearchDemo {

    public static void main(String[] args) {
	// write your code here

       int [] arr = new int[]{-1,3,19,28,90,190};
//       int result = BinarySearchNoRecursion(90, arr);
//       System.out.println(result);

        int result = BinarySearchRecursion(90, arr);
        System.out.println(result);
    }


    //二分查找递归
    public static int BinarySearchRecursion(int target,int arr []){

       return binarySearch(0,arr.length-1,target,arr);
    }

    private static int binarySearch(int start, int end, int target, int[] arr) {
        if(target<arr[0] || target > arr[arr.length-1]){
            return  -1 ;
        }
        int middle =  (start+end)/2 ;
        if(target>arr[middle]){
           return   binarySearch(middle,end,target,arr);
        }else if(target < arr[middle]) {
           return   binarySearch(start,middle,target,arr);
        }else {
            return middle;
        }

    }


    //二分查找非递归
    public static int BinarySearchNoRecursion(int target,int arr []){
        int left = 0 ;
        int right = arr.length-1;
        while ((left<=right)){
            int middle = (left+right)/2 ;
            if(arr[middle] == target){
                return middle;
            }else if(arr[middle] >target){
                right = middle -1 ;//如果中间的数都大于target ,则将right= middle - 1
            }else {
                left = middle+1 ;//如果中间的数都小于target ,则将  left= middle + 1
            }
        }
        return -1 ;
    }



}
