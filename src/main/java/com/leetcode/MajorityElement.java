package com.leetcode;

/**
 * @author: LongyunBian
 * @date: 2023/4/6 22:43
 * @Description: 多数元素
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int sum =1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==res){
                sum++;
            }else {
                sum--;
            }
            if (sum<0){
                res = nums[i];
                sum =1;
            }

        }
        return res;
    }
}
