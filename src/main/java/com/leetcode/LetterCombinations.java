package com.leetcode;
import java.util.ArrayList;
import java.util.List;
/**
 * @author: LongyunBian
 * @date: 2023/4/13 19:25
 * @Description: lc17
 */
public class LetterCombinations {
    StringBuffer path = new StringBuffer();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        String [] maps = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int [] nums = new int[digits.length()];
        for (int i =0;i<digits.length();i++) {
           nums[i]  = Integer.parseInt(String.valueOf(digits.charAt(i))) ;
        }

        backtracking(0, maps,digits.length(),nums);
        return  res;

    }
    private void backtracking(int start, String [] maps, int len, int [] nums){
        if(path.length()==len){
            res.add(path.toString());
            return;
        }

        for(int i = start;i<len;i++ ){
            for(int j = 0;j<maps[nums[i]].length();j++){
                path.append(maps[nums[i]].charAt(j));
                backtracking(i+1,maps,len,nums);
                path.deleteCharAt(path.length()-1);
                System.out.println(path);
            }

        }
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        List<String> strings = lc.letterCombinations("23");
    }
}
