package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: LongyunBian
 * @date: 2023/3/27 15:06
 * @Description: 两数之和
 */
public class TwoNum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                if (i!=map.get(target-nums[i]))
                    return new int[]{i,map.get(target-nums[i])};
            }
        }
        return null;
    }
}
