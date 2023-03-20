package com.tencent;
import java.util.Scanner;
import java.util.*;



public class MaximumConnectedGraph {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T =  in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int node1 = in.nextInt();
                int node2 = in.nextInt();
                if (!map.containsKey(node1)) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(node2);
                    map.put(node1,arr);
                } else {
                    ArrayList<Integer> arr = map.get(node1);
                    arr.add(node2);
                    map.put(node1, arr) ;
                }
                if (!map.containsKey(node2)) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(node1);
                    map.put(node2, arr) ;

                } else {
                    ArrayList<Integer> arr = map.get(node2);
                    arr.add(node1);
                    map.put(node2, arr) ;
                }
            }
            Set<Integer> set = new HashSet<>();
            int max = 0;
            while(set.size()<map.size()){
                int unvisited=0;
                for (int k:map.keySet()){
                    if (!set.contains(k))
                        unvisited = k;
                }
                int before = set.size();
                dfs(unvisited,set,map);
                int inc = set.size()-before;
                max=max>inc?max:inc;

            }
            System.out.println(max);
        }

    }

    private static void dfs(int i, Set<Integer> set, Map<Integer, ArrayList<Integer>> map) {
        if (i==0)
            return;
        set.add(i);
        ArrayList<Integer> connects = map.get(i);
        for (int j:connects){
            if (!set.contains(j))
                dfs(j,set,map);
        }

    }

}

