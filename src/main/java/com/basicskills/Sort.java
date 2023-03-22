package com.basicskills;

import static com.alibaba.MinimumRange.argmin;

public class Sort {
    // 冒泡排序
    public void bubbleSort(int [] nums){
        boolean flag = true;

        for (int i=0;i<nums.length;i++){
            int count = 0;
            for (int j= 0;j<nums.length-i-1;j++){
                if (nums[j]>nums[j+1]){
                    int t = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = t;
                }else {
                    count++;
                }
            }
            if (count==nums.length-i-1)
                break;
        }
    }
    //插入排序
    public void insertionSort(int [] nums){
        for (int i=1;i<nums.length;i++){
            int key =nums[i];
            int j = i-1;
            while (j>=0&&nums[j]> key){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }

    // 选择排序
    public void selectionSort(int [] nums){
        for (int i=0;i<nums.length;i++){
            int minIdx = argmin(nums,i);
            int t = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = t;
        }



    }

    private int argmin(int[] nums, int i) {
        int minIdx = i;
        for (int j=i+1;j<nums.length;j++){
            if (nums[j]<nums[minIdx]){
                minIdx = j;
            }
        }
        return minIdx;
    }
}
