package com.leetcode;

import com.utils.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: LongyunBian
 * @date: 2023/4/4 19:09
 * @Description: 合并k个升序链表
 */
public class MergeListK {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>( lists.length,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.getVal() - o2.getVal();
            }
        });
        pq.addAll(Arrays.asList(lists));
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (!pq.isEmpty()){
            ListNode top = pq.poll();
            tmp.next = top;
            tmp = tmp.next;
            if (top.next!=null){
                pq.add(top.next);
            }

        }
        return res.next;
    }
}
