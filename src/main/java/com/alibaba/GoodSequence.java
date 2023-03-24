package com.alibaba;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: LongyunBian
 * @date: 2023/3/24 16:10
 * @Description: 求字符串有多少个好序列
 */
public class GoodSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<Character,Integer> counts = new HashMap<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            counts.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
        }
        long sum = 0;
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            int value = entry.getValue();
            if (value>=2){
                sum+=combination(value)*(s.length()-value);
            }
        }
        int mod = (int) (1e9 + 7);
        System.out.println(sum%mod);
    }

    private static long combination(long value) {
        return value*(value-1)/2;
    }
}
