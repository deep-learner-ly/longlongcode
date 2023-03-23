package com.leetcode;

public class JumpGameIIChatGPT {
    public int jump(int[] nums) {
        int n = nums.length;
        int start = 0, end = 0;
        int jumps = 0;
        while (end < n - 1) {
            int maxEnd = end;
            for (int i = start; i <= end; i++) {
                int newEnd = i + nums[i];
                if (newEnd >= n - 1) {
                    return jumps + 1;
                }
                maxEnd = Math.max(maxEnd, newEnd);
            }
            jumps++;
            start = end + 1;
            end = maxEnd;
        }
        return jumps;
    }
}
