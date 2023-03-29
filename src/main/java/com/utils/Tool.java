package com.utils;

import java.util.List;

/**
 * @author: LongyunBian
 * @date: 2023/3/27 13:48
 * @Description: 工具类
 */
public class Tool {
    public static <T extends Comparable<? super T>> int bisectLeft(List<T> a, T x, int lo, int hi) {
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a.get(mid).compareTo(x) < 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    // 用于在一个有序列表中查找给定元素的插入位置，插入位置是指将该元素插入到列表中后，列表仍然保持有序。
    // 如果该元素已经在列表中存在，则返回它在列表中的最左边位置。
    public static  int bisectLeft(int  [] a, int x, int lo, int hi) {
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    public static  int bisectLeft(int  [] a, int x) {
        int lo = 0;
        int hi = a.length;
        return bisectLeft(a,x,lo,hi);
    }

    // 用于在已排序的整型数组 a 中查找第一个大于给定元素 x 的位置，
    // 如果所有元素都小于等于 x，则返回数组的长度`
    public static int bisectRight(int[] a, int x, int lo, int hi) {
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] <= x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    public static  int bisectRight(int  [] a, int x) {
        int lo = 0;
        int hi = a.length;
        return bisectRight(a,x,lo,hi);
    }

}
