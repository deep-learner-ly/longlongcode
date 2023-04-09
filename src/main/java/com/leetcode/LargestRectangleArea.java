package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: LongyunBian
 * @date: 2023/4/8 14:48
 * @Description: 单调栈解决最大矩形
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int [] hs = new int[heights.length+2];
        for (int i = 1; i <= heights.length; i++) {
            hs[i] = heights[i-1];
        }
        hs[0] = 0;
        hs[heights.length+1] = 0;
        int max = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < hs.length; i++) {
            if (hs[i]>hs[stack.peek()]){

            } else if (hs[i]==hs[stack.peek()]) {
                stack.pop();
            }else{
                while (hs[i]<hs[stack.peek()]){
                    int mid = stack.pop();
                    int left =stack.peek();
                    int s = hs[mid]*(i-left-1);
                    max = Math.max(max,s);
                }
            }
            stack.push(i);
        }
        return max;
    }
    int largestRectangleAreaLao(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();

        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        st.push(0);
        int result = 0;
        // 第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
            if (heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                st.push(i);
            } else {
                while (heights[i] < heights[st.peek()]) { // 注意是while
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LargestRectangleArea lr = new LargestRectangleArea();
        int [] hs = {2,1,5,6,2,3};
        System.out.println(lr.largestRectangleArea(hs));
    }
}
