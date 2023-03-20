package com.com.alibaba;


import java.util.Scanner;

public class NumOfFullBT {
    public static void main(String[] args) {
        // 题目描述：给定一棵二叉树， 试求这棵二叉树有多少个节点满足以该节点为根的子树是满二叉树?
        //我们定义一棵树是满二叉树，当且仅当每- -层的节点数量
        //都达到了最大值(即无法在这一层添加新节点)
        // 输入示例：
        // 6   结点数
        //2 3  第一个节点的左右子树节点
        //4 5  第二个节点的左右子树节点
        //6 -1 没有节点用-1表示
        //-1 -1
        //-1 -1
        //-1 -1
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] connections = new int[n][2];
        for (int i=0;i<n;i++){
            for (int j=0;j<2;j++){
                connections[i][j] = sc.nextInt();
            }
        }

        TreeNode [] nodes = new TreeNode[n];
        for (int i=0;i<n;i++){
            nodes[i] = new TreeNode();
        }
        for (int i=0;i<n;i++){
            if (connections[i][0]>0&&connections[i][0]<=n)
                nodes[i].left = nodes[connections[i][0]-1];
            if (connections[i][1]>0&&connections[i][1]<=n)
                nodes[i].right = nodes[connections[i][1]-1];
        }
        numFullBT(nodes[0]);
        System.out.println(nodes[0].num);

    }

    private static void numFullBT(TreeNode root) {
        if (root==null){
            return;
        }
        if (root.left==null&&root.right==null){
            root.isFull = true;
            root.num = 1;
            return;
        }
        numFullBT(root.left);
        numFullBT(root.right);
        if (root.left!=null){
            root.num+=root.left.num;
        }
        if (root.right!=null){
            root.num += root.right.num;
        }
        if (root.left==null||root.right==null){
            return;
        }

        if (root.left.isFull&&root.right.isFull&&root.left.num==root.right.num){
            root.num++;
            root.isFull = true;
        }
    }

}
class TreeNode{
    boolean isFull;
    int num;
    TreeNode left;
    TreeNode right;
}
