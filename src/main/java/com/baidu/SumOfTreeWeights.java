package com.baidu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SumOfTreeWeights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String colors = sc.next();
        int [][] connects = new int[n-1][2];
        for (int i=0;i<n-1;i++){
            for (int j=0;j<2;j++){
                connects[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int [][] adj = new int[n][n];
        for (int i=0;i<n-1;i++) {
            adj[connects[i][0]-1][connects[i][1]-1] =1;
            adj[connects[i][1]-1][connects[i][0]-1] =1;
        }
        Set<Integer> visited = new HashSet<>();
        int cursor = 0;
        int weights = 0;
        while (visited.size()<n){
            weights+= dfs(adj,cursor,visited,colors,0,0);
        }



        System.out.println(weights);

    }

    private static int  dfs(int[][] adj, int cursor, Set<Integer> visited,String colors,int parentRNum,int parentBNum) {

        int redNum =parentRNum;
        int blueNum =parentBNum;
        if (colors.charAt(cursor)=='R'){
            redNum++;
        }else {
            blueNum++;
        }
        visited.add(cursor);
        System.out.println(cursor+1);
        System.out.println("R: "+ redNum+"  B: "+blueNum);
        System.out.println("diff :"+(redNum-blueNum));
        int w = redNum>blueNum?redNum-blueNum:blueNum -redNum;
        for (int i=0;i<adj.length;i++){
            if (adj[cursor][i]==1 && !visited.contains(i)){
//                System.out.println(i+1);
                w+=dfs(adj,i,visited,colors,redNum,blueNum);

            }
        }
        return w;

    }

}
