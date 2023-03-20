package com.bytedance;
import java.util.Scanner;
public class AmbushPlan {
    // 题目描述
    // https://www.nowcoder.com/questionTerminal/c0803540c94848baac03096745b55b9b

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int []  points = new int [n];
        long count = 0;
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
            if (i >= 2) {
                int target = points[i] - d;
                int lo = 0;
                int hi = i;
                int closest = -1;
                while (lo<=hi){
                    int mid = (lo+hi)/2;
                    if (target==points[mid]) {
                        closest =mid;
                        break;
                    }
                    else if (target<points[mid]){
                        closest = mid;
                        hi = mid -1;
                    }

                    else{
                        lo = mid+1;
                    }

                }
                count +=c(i-closest);

            }

        }
        System.out.println(count % 99997867);

    }
    private static long c(long n){
        return n*(n-1)/2;
    }


}

