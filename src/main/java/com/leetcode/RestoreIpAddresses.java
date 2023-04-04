package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: LongyunBian
 * @date: 2023/3/30 14:38
 * @Description: 恢复ip地址
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        RestoreIpAddresses ipAddresses = new RestoreIpAddresses();
        ipAddresses.restoreIpAddresses("101023");
    }
    public List<String> restoreIpAddresses(String s) {
        if(s.length()<4||s.length()>12){
            return null;
        }
        if(s.equals("0000")){
            ArrayList<String> list = new ArrayList<>();
            list.add("0.0.0.0");
            return list;
        }

        List<String> res = new ArrayList<>();
        for(int split = 2;split<s.length()-1&&split<=6;split++) {
            if(s.length() - split>=2&&s.length()-split<=6){
                String left = s.substring(0,split);
                List<String> leftSet = addPoint(left);
                String right = s.substring(split);
                List<String> rightSet = addPoint(right);
                for(String s1:leftSet){
                    for(String s2:rightSet){
                        res.add(s1+"."+s2);
                    }
                }
            }
        }
        return res;
    }

    private static List<String> addPoint(String s){
        List<String> res = new ArrayList<>();
        for(int i=1;i<s.length()&&i<=3;i++){
            if(s.length() - i>=1&&s.length()-i<=3){
                String s1 = s.substring(0,i);
                String s2 = s.substring(i);
                if((s1.length()>=2&&s1.charAt(0)=='0')||(s2.length()>=2&&s2.charAt(0)=='0')){
                    continue;
                }
                int n1 = Integer.parseInt(s1);
                if(n1>255){
                    continue;
                }
                int n2 = Integer.parseInt(s2);
                if(n2>255){
                    continue;
                }
                res.add(s1+"."+s2);
            }
        }
        return res;
    }
}
