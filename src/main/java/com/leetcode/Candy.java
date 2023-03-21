package com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Candy {
    // leetcode 135
    public static void main(String[] args) {
        Candy cd = new Candy();
        int [] a = {1,0,2};
        System.out.println( cd.candy(a));



    }

    public int candy(int[] ratings) {
        int [] nums = new int[ratings.length];
        Arrays.fill(nums,1);
        for (int i=1;i<ratings.length;i++){
            if (ratings[i]>ratings[i-1])
                nums[i] = nums[i-1]+1;
        }
        int result = nums[ratings.length-1];
        for (int i=ratings.length-2;i>=0;i--){
            if (ratings[i]>ratings[i+1])
                nums[i] = Math.max(nums[i],nums[i+1] +1);
            result+=nums[i];
        }
        return result;

    }
}
