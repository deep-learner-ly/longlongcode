package com.basicskills;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void bubbleSort() {
        int max = 100000;
        int min = -100001;
        int len = 10000;
        int [] nums = new int[len];
        for (int i=0;i<len;i++)
           nums[i] = (int)(Math.random() * ((max - min) + 1)) + min;

        int [] numsCp = Arrays.copyOf(nums,nums.length);
        Sort sort = new Sort();
        sort.bubbleSort(nums);
        Arrays.sort(numsCp);
        for (int i=0;i<nums.length;i++)
            assert numsCp[i]==nums[i];
    }

    @Test
    public void insertionSort(){
        int max = 100000;
        int min = -100001;
        int len = 10000;
        int [] nums = new int[len];
        for (int i=0;i<len;i++)
            nums[i] = (int)(Math.random() * ((max - min) + 1)) + min;

        int [] numsCp = Arrays.copyOf(nums,nums.length);
        Sort sort = new Sort();
        sort.insertionSort(nums);
        Arrays.sort(numsCp);
        for (int i=0;i<nums.length;i++)
            assert numsCp[i]==nums[i];
    }

    @Test
    public void shellSort(){
        int max = 100000;
        int min = -100001;
        int len = 10000;
        int [] nums = new int[len];
        for (int i=0;i<len;i++)
            nums[i] = (int)(Math.random() * ((max - min) + 1)) + min;

        int [] numsCp = Arrays.copyOf(nums,nums.length);
        Sort sort = new Sort();
        sort.shellSort(nums);
        Arrays.sort(numsCp);
        for (int i=0;i<nums.length;i++)
            assert numsCp[i]==nums[i];
    }

    @Test
    public void selectionSort(){
        int max = 100000;
        int min = -100001;
        int len = 10000;
        int [] nums = new int[len];
        for (int i=0;i<len;i++)
            nums[i] = (int)(Math.random() * ((max - min) + 1)) + min;

        int [] numsCp = Arrays.copyOf(nums,nums.length);
        Sort sort = new Sort();
        sort.selectionSort(nums);
        Arrays.sort(numsCp);
        for (int i=0;i<nums.length;i++)
            assert numsCp[i]==nums[i];
    }
    @Test
    public void heapSort(){
        int max = 100000;
        int min = -100001;
        int len = 10000;
        int [] nums = new int[len];
        for (int i=0;i<len;i++)
            nums[i] = (int)(Math.random() * ((max - min) + 1)) + min;

        int [] numsCp = Arrays.copyOf(nums,nums.length);
        Sort sort = new Sort();
        sort.heapSort(nums);
        Arrays.sort(numsCp);
        for (int i=0;i<nums.length;i++)
            assert numsCp[i]==nums[i];
    }

    @Test
    public void quickSort(){
        int max = 10;
        int min = 0;
        int len = 15;
        int [] nums = new int[len];
        for (int i=0;i<len;i++)
            nums[i] = (int)(Math.random() * ((max - min) + 1)) + min;
//        int [] nums = {4,3,5,1,2,7,8,2};

        int [] numsCp = Arrays.copyOf(nums,nums.length);
        Sort sort = new Sort();
        sort.quickSort(nums);
        Arrays.sort(numsCp);
        for (int i=0;i<nums.length;i++)
            assert numsCp[i]==nums[i];
    }

    @Test
    public void mergeSort(){
        int max = 100000;
        int min = -100001;
        int len = 100;
        int [] nums = new int[len];
        for (int i=0;i<len;i++)
            nums[i] = (int)(Math.random() * ((max - min) + 1)) + min;

        int [] numsCp = Arrays.copyOf(nums,nums.length);
        Sort sort = new Sort();
        sort.mergeSort(nums);
        Arrays.sort(numsCp);
        for (int i=0;i<nums.length;i++)
            assert numsCp[i]==nums[i];
    }
}