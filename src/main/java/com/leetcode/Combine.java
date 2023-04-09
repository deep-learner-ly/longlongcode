package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: LongyunBian
 * @date: 2023/4/8 22:57
 * @Description: 77 回溯
 */
public class Combine {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {

        backtracking(1,n,k);
        System.out.println();
        return res;


    }
    private void backtracking(int startIdx,int n,int k){
        if(path.size()==k){
            res.add(new ArrayList<>(path) );
            return;
//
        }
        for(int i = startIdx;i <= n - (k - path.size()) + 1;i++){
            path.add(i);
            backtracking(i+1,n,k);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Combine com = new Combine();
        com.combine(4,2);

    }
}
