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
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
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

    public  String[] allLongestSubstringsWithoutRepeatingCharacters(String s) {
        int maxLen = 0;
        Set<String> maxSubstrings = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isSubstringWithoutRepeatingCharacters(substring)) {
                    if (substring.length() > maxLen) {
                        maxLen = substring.length();
                        maxSubstrings = new HashSet<>();
                        maxSubstrings.add(substring);
                    } else if (substring.length() == maxLen) {
                        maxSubstrings.add(substring);
                    }
                }
            }
        }
        return maxSubstrings.toArray(new String[0]);
    }

    private static boolean isSubstringWithoutRepeatingCharacters(String s) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (charSet.contains(s.charAt(i))) {
                return false;
            }
            charSet.add(s.charAt(i));
        }
        return true;
    }
    public static String generateRandomString(int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzaabbcc";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }
        return sb.toString();
    }


}
