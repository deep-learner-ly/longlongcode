package com.leetcode;

import java.util.ArrayList;

public class JumpGameII {

    public int jump(int[] nums) {
        ArrayList<Integer>[]  reachableSets = new ArrayList[nums.length];
        for(int i=0;i<nums.length;i++){
            reachableSets[i] = new ArrayList<>();
        }
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<=nums[i]&&(i+j)<nums.length;j++){
                reachableSets[i+j].add(i);
            }
        }
        int [] dp = new int [nums.length];
        for(int i=1;i<nums.length;i++){
            int min = Integer.MAX_VALUE;
            for(int pre:reachableSets[i]){
                min = min<dp[pre]?min:dp[pre];
            }
            min++;
            dp[i] = min;
            System.out.println(dp[i]);
        }
        return dp[nums.length-1];

    }
}
