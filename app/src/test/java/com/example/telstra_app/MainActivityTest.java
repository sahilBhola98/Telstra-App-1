package com.example.telstra_app;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest extends TestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void addTest(){
        int expected=30;
        int result=MainActivity.add(10,20);
        assertEquals(expected,result);
    }

}