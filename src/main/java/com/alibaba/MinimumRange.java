package com.alibaba;

import java.util.Scanner;

public class MinimumRange {
    // 题目描述：
    /* 给定-个大小为n的数组,你需要选择恰好k个元素，使
    每个元素分别进行一次如下操作:
            1.使该元素乘2。
            2.使该元素除以2，向下取整。
    请注意，对于每个元素只能进行两种操作中的一种，且只
    能操作-次。
    你需要使得k次操作后，数组的极差尽可能小。请你求出
    这个最小的极差。
    提示:数组的极差指数组的最大值减去最小值。

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for (int i=0;i<k;i++){
            int idxMin = argmin(a);
            int idxMax = argmax(a);
            int tmpMin = a[idxMin];
            a[idxMin] =  a[idxMin]*2;
            int diff1 = a[idxMax] - a[argmin(a)];
            a[idxMin] = tmpMin;
            int tmpMax = a[idxMax];
            a[idxMax] = a[idxMax]/2;
            int diff2 = a[argmax(a)] - a[idxMin];
            if (diff1<diff2){
                a[idxMin] =  a[idxMin]*2;
                a[idxMax] = tmpMax;
            }

        }
        int diff = a[argmax(a)] - a[argmin(a)];
        System.out.println(diff);
    }
    public static int argmax(int[] a) {
        int re = Integer.MIN_VALUE;
        int arg = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > re) {
                re = a[i];
                arg = i;
            }
        }
        return arg;
    }
    public static int argmin(int[] a) {
        int re = Integer.MAX_VALUE;
        int arg = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < re) {
                re = a[i];
                arg = i;
            }
        }
        return arg;
    }
}
