package com.tencent;
import java.util.Scanner;
import java.util.*;



public class MaxConnectedGraph {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T =  in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int node1 = in.nextInt();
                int node2 = in.nextInt();
                map.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
                map.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);

            }

            int max = 0;
            while(map.keySet().size()>max){
                int unvisited= (int) map.keySet().iterator().next();
                int before = map.keySet().size();
                dfs(unvisited, map);
                int inc = before - map.keySet().size();
                max=max>inc?max:inc;

            }
            System.out.println(max);
        }

    }

    private static void dfs(int i,  Map<Integer, ArrayList<Integer>> map) {
        if (i==0)
            return;
        ArrayList<Integer> connects = map.get(i);
        map.keySet().remove(i);
        for (int j:connects){
            if (map.keySet().contains(j))
                dfs(j, map);
        }

    }

}

