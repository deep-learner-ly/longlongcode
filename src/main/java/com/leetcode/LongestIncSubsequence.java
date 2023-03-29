package com.leetcode;

import com.utils.Tool;

/**
 * @author: LongyunBian
 * @date: 2023/3/27 11:22
 * @Description: 最长递增子序列
 */
public class LongestIncSubsequence {
    public int lengthOfLIS(int[] nums) {
        int count =0;
        for (int num:nums
             ) {
            int j = Tool.bisectLeft(nums,num,0,count);
            if (j==count){
                count++;
            }
            nums[j] = num;

        }
        return count;
    }
}
