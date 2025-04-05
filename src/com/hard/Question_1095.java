package com.hard;

// https://leetcode.com/problems/find-in-mountain-array/description/

public class Question_1095 {
    public static void main(String[] args) {
        MountainArray mountainArray = new MountainArrayImpl(new int[]{1, 2, 3, 4, 5, 3, 1});
        int target = 3;
        System.out.println(findInMountainArray(target, mountainArray));
    }

    interface MountainArray {
        int get(int index);
        int length();
    }

    static class MountainArrayImpl implements MountainArray {
        private final int[] arr;

        public MountainArrayImpl(int[] arr) {
            this.arr = arr;
        }

        @Override
        public int get(int index) {
            return arr[index];
        }

        @Override
        public int length() {
            return arr.length;
        }
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeakElement(mountainArr);
        int firstTry = orderAgnosticBS(mountainArr, target, 0, peak);
        if(firstTry != -1) {
            return firstTry;
        }
        return orderAgnosticBS(mountainArr, target, peak + 1, mountainArr.length() - 1);
    }

    public static int findPeakElement(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            if(mountainArr.get(mid) > mountainArr.get(mid + 1)){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int orderAgnosticBS(MountainArray mountainArr, int target, int start, int end){
        boolean isAsc = mountainArr.get(start) < mountainArr.get(end);

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(target == mountainArr.get(mid)){
                return mid;
            }

            if(isAsc) {
                if (target < mountainArr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > mountainArr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
