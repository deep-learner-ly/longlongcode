package com.leetcode;

import java.util.Stack;

/**
 * @author: LongyunBian
 * @date: 2023/4/7 19:50
 * @Description: leetcode 739 单调栈
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        int [] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (temperatures[i]>temperatures[stack.peek()]&&!stack.isEmpty()){
                int j = stack.peek();
                res[j] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
