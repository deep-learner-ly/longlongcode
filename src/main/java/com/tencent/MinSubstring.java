package com.tencent;
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class MinSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        class Char2Index implements Comparable<Char2Index> {
            char c;
            int idx;
            public Char2Index(char c,int idx){
                this.c = c;
                this.idx = idx;
            }
            @Override
            public int compareTo(Char2Index o) {
                return c-o.c;
            }
        }
        PriorityQueue<Char2Index> pq = new PriorityQueue<>();
        for (int i=0;i<s.length();i++){

            pq.add(new Char2Index(s.charAt(i),i));

        }

        Set<String> set = new HashSet<>();
        while (true){
            ArrayList<Char2Index> tops = new ArrayList<>();
            tops.add(pq.poll());

            while (!pq.isEmpty()&& pq.peek().compareTo(tops.get(0))==0){
                tops.add(pq.poll());
            }

            set.add(String.valueOf(tops.get(0).c));
            int strSize = 2;
            while (strSize<=s.length()){
                for (Char2Index top:tops){
                    int idx = top.idx;
                    if (idx+strSize<=s.length()){
                        set.add(s.substring(idx,idx+strSize));
                    }
                }
                strSize++;

            }
            if (set.size()>=k){
                break;
            }

        }
//        for (String string:set){
//            System.out.println(string);
//        }
        PriorityQueue<String> queue  = new PriorityQueue<>(String.CASE_INSENSITIVE_ORDER.reversed());
        for (String string:set) {

            queue.offer(string);
            // 堆中元素多于k个时，删除堆顶元素
            if (queue.size() > k) {
                queue.poll();
//                System.out.println(queue.poll());
            }
        }
        System.out.println(queue.peek());

    }




}