package com.leetcode;

import com.utils.Tool;

/**
 * @author: LongyunBian
 * @date: 2023/4/6 23:35
 * @Description: 二维矩阵查找
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int res = Tool.bisectLeft(matrix[i], target, 0, matrix[i].length - 1);
            if (res==target)
                return true;
        }
        return false;

    }



    public static void main(String[] args) {
        SearchMatrix sm = new SearchMatrix();
        int [] [] matrix = {{1, 4},{2, 5}};
        System.out.println(sm.searchMatrix(matrix, 2));
    }
}
