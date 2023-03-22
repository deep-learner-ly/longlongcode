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
}