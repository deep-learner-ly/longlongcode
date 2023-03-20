package com.leetcode;

import java.util.*;

class MinWindow {
    //最优解法： 滑动窗口法
    public static void main(String[] args) {
        MinWindow m = new MinWindow();
        System.out.println( m.minWindow("aaflslflsldkalskaaa", "aaa"));

    }

    public String minWindow(String s, String t) {
        if (s.length()<t.length()){
            return "";
        }
        char[] tcs = t.toCharArray();
        Map<Character, Integer> tCount = new HashMap<>();

        for (char tc : tcs) {
            Integer v = tCount.get(tc);
            if (v == null) {
                tCount.put(tc, 1);
            } else {
                tCount.put(tc, v + 1);
            }
        }
        char[] scs = s.toCharArray();
        Map<Integer,Character> idx2char = new TreeMap<>();
        for (int i = 0; i < scs.length; i++) {
            if (tCount.containsKey(scs[i])){
                idx2char.put(i,scs[i]);
            }
        }

        int minLen = 100*1000+1;
        int start = -1;
        int begin = -1;
        while (idx2char.size()>=t.length()){
            int i=0;
            ArrayList<Character> chars = new ArrayList<>();
            for(int idx:idx2char.keySet()){
                if (i==0){
                    start=idx;
                    i++;
                }
                chars.add(idx2char.get(idx));
                if (chars.size()>=t.length()&& isCover(chars,tCount)){
                    if (minLen > idx - start + 1){
                        minLen = idx - start + 1;
                        begin = start;
                    }

                    System.out.println(minLen);
                }
            }
            idx2char.remove(start);
        }

        if (begin==-1){
            return "";
        }
//        System.out.println(s.substring(begin,begin+minLen));
        return s.substring(begin,begin+minLen);


    }

    private boolean isCover(ArrayList<Character> chars, Map<Character, Integer> tCount) {
        Map<Character, Integer> count = new HashMap<>();
        for (char tmpChar:chars){
            count.putIfAbsent(tmpChar,0);
            count.put(tmpChar, count.get(tmpChar)+1);
        }
        for (char tChar :tCount.keySet()){
            if (!count.containsKey(tChar))
                return false;
            if (count.get(tChar)<tCount.get(tChar))
                return false;
        }
        return true;
    }

}