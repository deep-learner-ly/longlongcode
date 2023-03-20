package com.baidu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumOfPalindromeSubString {
    /*
     题目描述： 给定一个整数 x，请你构造一个仅由 'r'、'e'、'd' 三种字符组成的字符串，其中回文子串的数量恰好为 x 字符串长度不得超过 100000
     */
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        NumOfPalindromeSubString numOfPalindromeSubString = new NumOfPalindromeSubString();

        System.out.println(numOfPalindromeSubString.bulidMyString(x));
    }
    public String bulidMyString(int x){
        int closest = 0;
        List<Integer> lens = new ArrayList<>();
        while (x>=0){
            for (int i=1;i<=x;i++){
                if (i*(i+1)==2*x) {
                    closest = i*(i+1)/2;
                    lens.add(i);
                    break;
                }

                if (i*(i+1)>2*x){
                    closest = i*(i-1)/2;
                    lens.add(i-1);

                    break;
                }
            }
            x = x-closest;

        }
//        System.out.println(lens);
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i =0;i<lens.size();i++){
            if (i%3==0){
                stringBuilder.append(String.join("", Collections.nCopies(lens.get(i), "r")));
            }
            else if (i%3==1){
                stringBuilder.append(String.join("", Collections.nCopies(lens.get(i), "e")));
            }
            else if (i%3==2){
                stringBuilder.append(String.join("", Collections.nCopies(lens.get(i), "d")));
            }
        }
        return stringBuilder.toString();
    }
    public int countSubstrings(String s) {
        int num = 0;
        for (int i=0; i < s.length(); i++){
            num+=count(s, i, i);//回文串长度为奇数
            num+=count(s, i, i+1);//回文串长度为偶数
        }
        return num;
    }

    public int count(String s, int start, int end){
        int num=0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            num++;
            start--;
            end++;
        }
        return num;
    }
}
