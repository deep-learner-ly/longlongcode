package com.leetcode;

import java.util.Stack;

/**
 * @author: LongyunBian
 * @date: 2023/4/13 11:39
 * @Description: 接雨水，单调栈
 */
public class TrappingRainWater42 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i =0 ;i<height.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                if(height[i]<height[stack.peek()]){
//                    stack.push(i);
                }else if(height[i]==height[stack.peek()]){
                    stack.pop();
//                    stack.push(i);
                }else{
                    while (!stack.empty() && height[i] > height[stack.peek()]) { // 注意这里是while
                        int mid = stack.peek();
                        stack.pop();
                        if (!stack.empty()) {
                            int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                            int w = i - stack.peek() - 1; // 注意减一，只求中间宽度
                            sum += h * w;
                        }
                    }

                }
                stack.push(i);
            }
        }
        return sum;

    }
}
