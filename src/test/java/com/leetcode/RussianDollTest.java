package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RussianDollTest {

    @Test
    public void maxEnvelopes() {
        int [][]envs = {{5,2},{5,4},{6,4},{6,7},{2,3}};
        RussianDoll russianDoll = new RussianDoll();
        russianDoll.maxEnvelopes(envs);
    }
}