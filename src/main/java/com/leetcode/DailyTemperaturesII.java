package com.leetcode;

import java.util.Stack;

/**
 * @author: LongyunBian
 * @date: 2023/4/8 14:24
 * @Description: 每日温度，成环
 */
public class DailyTemperaturesII {
    public int[] dailyTemperaturesII(int[] temperatures) {

        int [] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < 2* temperatures.length; i++) {
            int idx = i%temperatures.length;
            while (!stack.isEmpty()&&temperatures[idx]>temperatures[stack.peek()]){
                int j = stack.peek();
                res[j] = idx - stack.pop();
            }
            stack.push(idx);
        }
        return res;
    }
}
