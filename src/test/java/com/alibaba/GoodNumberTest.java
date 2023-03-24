package com.alibaba;

import org.junit.Test;

import java.util.Timer;

import static org.junit.Assert.*;

public class GoodNumberTest {

    @Test
    public void maxKGoodNum() {
        GoodNumber goodNumber = new GoodNumber();
        int [] myResults = new  int[888];
        int [] hisResults = new  int[888];
        long startTime = System.currentTimeMillis();
        for (int k=1;k<888;k++){
               myResults[k] = goodNumber.MaxKGoodNum(k);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("MY 程序运行时间：" + elapsedTime + "毫秒");
        long startTime1 = System.currentTimeMillis();
        for (int k=1;k<888;k++){
            hisResults[k] = GoodNumber.getValue(k);
        }
        long endTime1 = System.currentTimeMillis();
        long elapsedTime1 = endTime1 - startTime1;
        System.out.println("HIS 程序运行时间：" + elapsedTime1+ "毫秒");
        for (int k=1;k<888;k++)
            assert myResults[k]==hisResults[k];
    }
}