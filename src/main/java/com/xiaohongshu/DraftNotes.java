package com.xiaohongshu;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: LongyunBian
 * @date: 2023/3/26 13:46
 * @Description:
 * 1.输入字符包括，"("    ,    ")"    和    "<"和其他字符。
 * 2.其他字符表示笔记内容。
 * 3.()之间表示注释内容，任何字符都无效。    括号保证成对出现。
 * 4."<"表示退格,    删去前面一个笔记内容字符。括号不受"<"影响    。
 */
public class DraftNotes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String notes = sc.next();
        Stack<Character> stack = new Stack<>();
        int flag = 0;
        char [] chars = notes.toCharArray();
        for (char c:chars){
            if (c=='('){
                flag--;
            }
            if (c==')'){
                flag++;
                continue;
            }
            if (flag==0&&c!='<'){
                stack.add(c);
            }

            if (flag==0&&c=='<'){
//                System.out.println(stack.pop());
                stack.pop();

            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.insert(0, stack.pop());
        }
        System.out.println(res.toString());
    }
}
