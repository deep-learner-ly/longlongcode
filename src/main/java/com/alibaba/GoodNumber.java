package com.alibaba;

/**
 * @author: LongyunBian
 * @date: 2023/3/24 15:51
 * @Description: 求第k大的好数
 */

import java.util.*;

public class GoodNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println(new GoodNumber().maxGoodNumK(k));

    }
    public int maxGoodNumK(int k){
        int [] nums = new int[10];
        for (int i=0;i<nums.length;i++){
            nums[i] = i;
        }
        int [] bits = new int[5];
        int m =9, n =4;
        ArrayList<Integer> arr = new ArrayList<>();
        while (k>1){
            int numberPermutations = arrange(m,n);
            int num = find(k,numberPermutations);
            arr.add(num);
            k -=num*numberPermutations;
            m--;
            n--;
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<arr.size();i++){
            bits[i] = getMaxK(nums,arr.get(i)+1);
            res.append(bits[i]);
        }
        int diffNums = 5 - res.length();

        if (diffNums !=0){
            res.append(maxBitsK(nums, diffNums));
        }
        return Integer.parseInt(res.toString());


    }

    private static String maxBitsK(int[] nums, int bits) {
        StringBuilder s = new StringBuilder();
        int k=0;
        for (int i=nums.length-1;i>=0;i--){
            if (nums[i]!=-1){
                s.append(nums[i]);
                k++;
                if (k==bits){
                    return s.toString();
                }

            }
        }
        return s.toString();
    }


    private static int find(int k, int numberPermutations) {
        int num =0;
        while (k>numberPermutations){
            k-=numberPermutations;
            num++;
        }
        return num;
    }
    private static int getMaxK(int [] nums , int kth){
        int k=0;
        for (int i=nums.length-1;i>=0;i--){
            if (nums[i]!=-1){
                k++;
                if (k==kth){
                    int t =nums[i];
                    nums[i] =-1;
                    return t;
                }

            }
        }
        return -1;
    }

    static int arrange(int m, int n){
        int res =1;
        for (int i=0;i<n;i++){
            res*=m;
            m--;
        }
        return res;
    }


    public static int getValue(int k) {
        List<Integer> q = new ArrayList<>();
        int start = 1234;
        int end = 100000;
        for (int i = start; i < end; i++) {
            StringBuilder s = new StringBuilder(String.valueOf(i));
            int d = 5 - s.length();
            for (int j = 0; j < d; j++) {
                s.insert(0, "0");
            }
            if (new HashSet<>(Arrays.asList(s.toString().split(""))).size() == 5) {
                q.add(Integer.parseInt(s.toString()));
            }
        }
        Collections.sort(q, Collections.reverseOrder());
        return q.get(k - 1);
    }
}
