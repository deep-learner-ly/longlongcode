package com.leetcode;

import com.utils.ListNode;

/**
 * @author: LongyunBian
 * @date: 2023/4/12 9:06
 * @Description: 大数相加 链表反转
 */
public class AddBigNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode res = new ListNode(-1);
        ListNode p3 = res;
        while (p1!=null&&p2!=null){
            int sum = carry +p1.val +p2.val;
            carry = sum/10;
            sum = sum%10;
            p3.next = new ListNode(sum);
            p3 = p3.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1!=null){
            int sum = carry +p1.val;
            carry = sum/10;
            sum = sum%10;
            p3.next = new ListNode(sum);
            p3 = p3.next;
            p1 = p1.next;
        }
        while (p2!=null){
            int sum = carry +p2.val;
            carry = sum/10;
            sum = sum%10;
            p3.next = new ListNode(sum);
            p3 = p3.next;
            p2 = p2.next;
        }
        if (carry==1){
            p3.next = new ListNode(carry);
            p3 = p3.next;
        }
        return reverse(res.next);
    }
    private ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }
        ListNode p = head.next;
        ListNode pre = head;
        while(p!=null){
            pre.next = p.next;
            p.next = head;
            head = p;
            p = pre.next;

        }
        return head;
    }

    public static void main(String[] args) {
        int []  l1 = {7,2,4,3};
        int [] l2 = {5,6,4};
        ListNode h1 = new ListNode(-1);
        ListNode p =h1;
        for (int i : l1) {
            p.next= new ListNode(i);
            p = p.next;
        }
        ListNode ll1 = h1.next;
        ListNode h2 = new ListNode(-1);
        p = h2;
        for (int i:l2){
            p.next = new ListNode(i);
            p = p.next;
        }
        ListNode ll2 = h2.next;
        AddBigNum addBigNum = new AddBigNum();
        ListNode listNode = addBigNum.addTwoNumbers(ll1, ll2);
        System.out.println();
    }
}
