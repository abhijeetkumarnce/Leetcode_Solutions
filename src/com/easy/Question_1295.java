package com.easy;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/

public class Question_1295 {
    public static void main(String[] args) {
        int[] nums =  {437,315,322,431,686,264,442};
        int ans = findNumbers(nums);
        System.out.println(ans);
    }

    static int findNumbers(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int count = (int) Math.log10(nums[i]) + 1;
            /*int count = 0;
            while(nums[i] != 0){
                nums[i] /= 10;
                count++;
            }*/
            if(count % 2 == 0){
                ans++;
            }
        }
        return ans;
    }
}