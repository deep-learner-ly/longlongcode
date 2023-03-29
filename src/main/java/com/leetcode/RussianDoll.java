package com.leetcode;

import java.util.Arrays;

/**
 * @author: LongyunBian
 * @date: 2023/3/27 14:31
 * @Description: 俄罗斯套娃-二维最长递增子序列
 */
public class RussianDoll {
    class Envelope implements Comparable<Envelope> {

        int w;
        int h;

        public Envelope(int w, int h) {
            this.w = w;
            this.h = h;
        }

        @Override
        public int compareTo(Envelope o) {
            if (w>o.w){
                return 1;
            }else if (w<o.w){
                return -1;
            }else return Integer.compare(o.h, h);
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        Envelope [] arr = new Envelope[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            arr[i] = new Envelope(envelopes[i][0],envelopes[i][1]);
        }
        Arrays.sort(arr);
        int [] nums = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            nums[i] = arr[i].h;

        }
        LongestIncSubsequence LIS = new LongestIncSubsequence();
        return LIS.lengthOfLIS(nums);


    }
}
