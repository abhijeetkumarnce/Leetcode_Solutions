package com.hard;

// https://leetcode.com/problems/split-array-largest-sum/description/

public class Question_410 {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }

    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for (int j : nums) {
            start = Math.max(start, j);
            end += j;
        }

        while(start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int pieces = 1;

            for(int num : nums) {
                if(sum + num > mid) {
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if(pieces > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
