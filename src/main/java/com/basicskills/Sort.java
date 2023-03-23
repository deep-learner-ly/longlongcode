package com.basicskills;

import java.util.PriorityQueue;

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

    // 希尔排序
    public  void  shellSort(int [] nums){

        for (int gap =nums.length/2;gap>0;gap/=2){
            for (int i =gap;i<nums.length;i++){
                int key = nums[i];
                int j = i-gap;
                while (j>=0&&nums[j]>key){
                    nums[j+gap] = nums[j];
                    j-=gap;
                }
                nums[j+gap] =key;
            }
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

    // 堆排序
    public void heapSort(int [] nums){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num:nums)
            pq.add(num);
        for (int i=0;i<nums.length;i++)
            nums[i] = pq.poll();
    }

    // 快速排序
    public void quickSort(int [] nums){
        quick(nums,0,nums.length-1);


    }

    private void quick(int[] nums, int lo, int hi) {
        if (lo<hi){
            int part = partition(nums,lo,hi);
            quick(nums,lo,part-1);
            quick(nums,part+1,hi);
        }

    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo;
        int j = hi;
        while (i<j){
            while (i<j && nums[j]>=pivot)
                j--;
            while (i<j && nums[i]<=pivot)
                i++;
            swap(nums,i,j);

        }

        nums[lo] = nums[j];
        nums[j]  = pivot;

        return j;


    }

    private void swap(int[] nums, int i, int j) {
        int t =nums[i];
        nums[i] = nums[j];
        nums[j] =t;
    }

    // 归并排序
    public void mergeSort(int [] nums){
        merge(nums,0,nums.length-1);
    }


    private void merge(int[] nums, int lo, int hi) {
        if (lo>=hi)
            return;
        int mid = (lo+hi)/2;
        merge(nums,lo,mid);
        merge(nums,mid+1,hi);
        int [] tmpArr = new int [hi-lo+1];
        int i=lo,j=mid+1;
        int k = 0;
        while (i<=mid&&j<=hi){
            if (nums[i]<nums[j])
                tmpArr[k++] = nums[i++];
            else
                tmpArr[k++] = nums[j++];
        }
        while (i<=mid)
            tmpArr[k++] = nums[i++];
        while (j<=hi)
            tmpArr[k++] = nums[j++];
        for (int l = lo; l <=hi; l++) {
            nums[l] =tmpArr[l-lo];
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
