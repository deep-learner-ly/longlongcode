package com.bytedance;

import java.util.Scanner;

public class AmbushPlanWithWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int [] points = new int [n];
        for (int i=0;i<n;i++){
            points[i] = sc.nextInt();
        }
        int right = 2;
        int left = 0;
        long count =0;
        while (left<n-2){
            while (right<n&&points[right] - points[left]<=d)
                right++;
            if (right - 1 - left >= 2)
                count+=c(right-left-1);
            left++;
        }
        System.out.println(count);


    }
    private static long c(long n){
        return n*(n-1)/2;
    }
}
