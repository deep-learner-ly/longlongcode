package com.leetcode;

import java.util.*;

/**
 * @author: LongyunBian
 * @date: 2023/3/29 17:17
 * @Description: 最长无重复子串
 */
public class LongestSubstrings {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                System.out.println(left);
                System.out.println(map.get(s.charAt(i)) + 1);
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
//            System.out.println(i-left+1);
            max = Math.max(max,i-left+1);
        }
        return max;

    }
    public String[] longestSubstrings(String s) {
        if (s.length()==0){
            return null;
        }
        int [] lens = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
//                System.out.println(left);
//                System.out.println(map.get(s.charAt(i)) + 1);
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            lens[right] = right -left+1;
            map.put(s.charAt(right), right);
            max = Math.max(max,lens[right]);
        }
        HashSet<String> res = new HashSet<>();
        for (int i = max-1; i < lens.length; i++) {
            if (lens[i]==max){
                res.add(s.substring(i-max+1,i+1));
            }
        }
        return res.toArray(new String[0]);

    }

    public static void main(String[] args) {
        LongestSubstrings ls = new LongestSubstrings();
        String[] res = ls.longestSubstrings("abcabcbb");
        for (String re : res) {
//            System.out.println(re);
        }

    }


}
