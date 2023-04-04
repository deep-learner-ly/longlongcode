package com.utils;

import lombok.Data;

/**
 * @author: LongyunBian
 * @date: 2023/4/4 19:10
 * @Description: 链表节点
 */
@Data
public class ListNode {
     public int val;
     public ListNode next;
     ListNode() {}
     public ListNode(int val) { this.val = val; }
     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
