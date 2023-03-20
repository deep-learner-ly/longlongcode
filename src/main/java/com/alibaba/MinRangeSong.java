package com.alibaba;

import java.util.*;

public class MinRangeSong {
    public static int[] topK(int[] nums, int k, boolean isMax) {
        PriorityQueue<Integer> pq;
        if (isMax) pq = new PriorityQueue<>(k, Collections.reverseOrder()); // 大根堆
        else pq = new PriorityQueue<>(k); // 小根堆
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] a = new int[n];
        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int [] minK1 = topK(a,k+1<n?k+1:n,false);
        int [] maxK1 = topK(a,k+1<n?k+1:n,true);
        int[] oldMaxs = Arrays.copyOf(maxK1, maxK1.length);

        for (int i=0;i<k;i++){
            minK1[i] *=2;
            maxK1[i] /=2;
        }
        int diffMin = Integer.MAX_VALUE;
        for (int i=0;i<minK1.length;i++){
            int min = minK1[0]<minK1[i]/2?minK1[0]:minK1[i]/2;
            int max = maxK1[0]>oldMaxs[minK1.length-1-i]?maxK1[0]:oldMaxs[minK1.length-1-i];
            diffMin = Math.min(diffMin, (max - min));

        }
        System.out.println(diffMin);


    }
}
