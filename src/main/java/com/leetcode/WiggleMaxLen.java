package com.leetcode;

public class WiggleMaxLen {
    // leetcode 376
    // 统计摆动次数
    public int wiggleMaxLength(int[] nums) {
        int sum = 1;
        int flag = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]&&(flag==0||flag==-1)){
                sum++;
                flag =1;
            }else if(nums[i]<nums[i-1]&&(flag==0||flag==1)){
                sum++;
                flag=-1;
            }
        }
        return sum;

    }
}
