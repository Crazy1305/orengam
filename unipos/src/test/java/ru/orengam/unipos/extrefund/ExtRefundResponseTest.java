/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.extrefund;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.orengam.unipos.ParseError;
import static ru.orengam.unipos.RefundType.*;

/**
 *
 * @author vadim.shakirov
 */
public class ExtRefundResponseTest {
    
    private ExtRefundResponse instance;
    private static String s = "S000300000000000000056013261004+0000000000+00000000000000000000";
    
    public ExtRefundResponseTest() {
    }
    
    @Before
    public void setUp() throws ParseError {
        instance = new ExtRefundResponse(s);
    }

    /**
     * Test of getPackageNum method, of class ExtRefundResponse.
     */
    @Test
    public void testGetPackageNum() {
        System.out.println("getPackageNum");
        int expResult = 3;
        int result = instance.getPackageNum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRefundCode method, of class ExtRefundResponse.
     */
    @Test
    public void testGetRefundCode() {
        System.out.println("getRefundCode");
        byte expResult = 0;
        byte result = instance.getRefundCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRefundType method, of class ExtRefundResponse.
     */
    @Test
    public void testGetRefundType() {
        System.out.println("getRefundType");
        byte expResult = RT_DEFAULT;
        byte result = instance.getRefundType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardType method, of class ExtRefundResponse.
     */
    @Test
    public void testGetCardType() {
        System.out.println("getCardType");
        int expResult = 0;
        int result = instance.getCardType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardNumber method, of class ExtRefundResponse.
     */
    @Test
    public void testGetCardNumber() {
        System.out.println("getCardNumber");
        String expResult = "0000000056013261";
        String result = instance.getCardNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRfu method, of class ExtRefundResponse.
     */
    @Test
    public void testGetRfu() {
        System.out.println("getRfu");
        int expResult = 4;
        int result = instance.getRfu();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBalanceBefore method, of class ExtRefundResponse.
     */
    @Test
    public void testGetBalanceBefore() {
        System.out.println("getBalanceBefore");
        int expResult = 0;
        int result = instance.getBalanceBefore();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBalanceAfter method, of class ExtRefundResponse.
     */
    @Test
    public void testGetBalanceAfter() {
        System.out.println("getBalanceAfter");
        int expResult = 0;
        int result = instance.getBalanceAfter();
        assertEquals(expResult, result);
    }

    /**
     * Test of getExtReturnCode method, of class ExtRefundResponse.
     */
    @Test
    public void testGetExtReturnCode() {
        System.out.println("getExtReturnCode");
        String expResult = "0000000000";
        String result = instance.getExtReturnCode();
        assertEquals(expResult, result);
    }
    
}
