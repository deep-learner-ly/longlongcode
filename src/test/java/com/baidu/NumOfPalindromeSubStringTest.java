package com.baidu;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumOfPalindromeSubStringTest {
    private NumOfPalindromeSubString numOfPalindromeSubString;

    @Test
    public void bulidMyString() {
        numOfPalindromeSubString = new NumOfPalindromeSubString();
        int min = 1;
        int max = 100000;
        for (int i=0;i<100000;i++){
            int x = min + (int)(Math.random() * (max-min+1));
            String res =  numOfPalindromeSubString.bulidMyString(x);
            assert res.length()<=100000;

            assert x== numOfPalindromeSubString.countSubstrings(res);
        }


    }
}