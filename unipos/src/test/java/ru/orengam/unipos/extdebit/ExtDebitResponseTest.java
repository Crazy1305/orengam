/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.extdebit;

import ru.orengam.unipos.extdebit.ExtDebitResponse;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import ru.orengam.unipos.ParseError;

/**
 *
 * @author vadim.shakirov
 */
public class ExtDebitResponseTest {
    
    private static ExtDebitResponse instance;
    private static String s = "Y00000000000005603091300000000000000000000+0000000000000000000000000001";
    
    public ExtDebitResponseTest() {
    }
    
    @Before
    public void setUp() throws ParseError {
        instance = new ExtDebitResponse(s);
    }

    /**
     * Test of getReturnCode method, of class ExtDebitResponse.
     */
    @Test
    public void testGetReturnCode() {
        int result = instance.getReturnCode();
        assertEquals(0, result);
    }

    /**
     * Test of getCardType method, of class ExtDebitResponse.
     */
    @Test
    public void testGetCardType() {
        int expResult = 0;
        int result = instance.getCardType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardNumber method, of class ExtDebitResponse.
     */
    @Test
    public void testGetCardNumber() {
        String expResult = "0000000056030913";
        String result = instance.getCardNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPan method, of class ExtDebitResponse.
     */
    @Test
    public void testGetPan() {
        String expResult = "00000000000000000000";
        String result = instance.getPan();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBalance method, of class ExtDebitResponse.
     */
    @Test
    public void testGetBalance() {
        int expResult = 0;
        int result = instance.getBalance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRejectedCount method, of class ExtDebitResponse.
     */
    @Test
    public void testGetRejectedCount() {
        int expResult = 0;
        int result = instance.getRejectedCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGoodsCode method, of class ExtDebitResponse.
     */
    @Test
    public void testGetGoodsCode() {
        int expResult = 0;
        int result = instance.getGoodsCode();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getChequeNum method, of class ExtDebitResponse.
     */
    @Test
    public void getChequeNum() {
        int expResult = 1;
        int result = instance.getChequeNum();
        assertEquals(expResult, result);
    }
    
}
