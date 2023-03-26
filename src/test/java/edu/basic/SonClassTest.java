package edu.basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class SonClassTest {

    @Test
    public void methodB() {
        BaseClass base = new SonClass();
        base.method();
        // 以下语句会报错
        // base.methodB();
        SonClass sonClass = (SonClass) base;
        sonClass.methodB();
    }
}