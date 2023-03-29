package com.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ToolTest {

    @Test
    public void bisectLeft() {
        int [] a= {1,2,4,4,4,5};
        System.out.println(Tool.bisectLeft(a, 6));
    }
}