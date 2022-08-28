package com.company.stackorDeque;

import java.util.Arrays;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class maxSlidingWindow {
    public static void main(String[] args) {
        int []  nums = new int[] {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    public  static int[] maxSlidingWindow(int[] nums, int k) {
        //特殊情况
        if(nums.length == 0) return new int[]{};
        if(k == 1) return  nums;
        //滑动窗口左右指针
        int right = 0, left = 0, count = 0, max = Integer.MIN_VALUE;
        int[] res = new int[nums.length - k + 1];

        while (right < nums.length) {
            //r是移入窗口的值，并记录窗口中最大值
            int r = nums[right];
            if (r > max) max = r;
            //右移窗口
            right++;

            while (right-left == k) { //达到窗口长度
                res[count] = max;  //该窗口最大值记录进数组
                count++;

                int l = nums[left];  //l是即将移出窗口的值
                if(l == max){       //如果移出的是最大值，将max改为剩下窗口内元素的最大值
                    int tmp = Integer.MIN_VALUE;
                    for (int i = left + 1; i < right ; i++) {
                        if (nums[i] > tmp) tmp = nums[i];
                    }
                    max = tmp;
                }
                // 左移窗口，即窗口缩小
                left++;
            }
        }
        return res;
    }
}
