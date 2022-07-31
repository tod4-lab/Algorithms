package com.hikaru.one.binarySearch;

public class BinarySearch {
    public static int bs(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi) {
            int mi = (lo + hi) / 2;
            if(nums[mi] == target)
                return mi;
            else if (nums[mi] < target) {
                lo = mi + 1;
            }
            else hi = mi - 1;
        }
        return lo;
    }
    public static void main(String[] args) {


    }
}
