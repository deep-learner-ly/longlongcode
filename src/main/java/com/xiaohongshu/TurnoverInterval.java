package com.xiaohongshu;

import java.util.Scanner;

/**
 * @ClassName TurnoverInterval
 * @Author ly
 * @Date 2023/3/25 下午11:52
 * @Description 翻转后1的个数最多
 **/
public class TurnoverInterval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums  = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = sc.nextInt();
            if (nums[i]==0){
                nums[i] =-1;
            }
        }
        int minIdx = 0;
        for (int i=1;i<n;i++){
            nums[i] +=nums[i-1];
            if (nums[i]<=nums[minIdx])
                minIdx =i;
        }
        int maxIdx = minIdx;

        for (int i =minIdx;i>=0;i--){
            if (nums[i]>nums[maxIdx])
                maxIdx = i;
        }
        System.out.println(nums[maxIdx]);
        System.out.println(nums[minIdx]);
        if (nums[maxIdx]>0)
            System.out.println(nums[maxIdx] - nums[minIdx]);
        else
            System.out.println(-nums[minIdx]);
    }
}
