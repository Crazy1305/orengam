/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.extinfo;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.orengam.unipos.ParseError;

/**
 *
 * @author vadim.shakirov
 */
public class ExtInfoResponseTest {
    
    private ExtInfoResponse instance;
    private final String testString = "a0001000000000005056033120006121"
            + "Цена клиента 38.50 р.21"
            + "200617000999990000099999000"
            + "20061700099999000009999900000006371300";
    
    public ExtInfoResponseTest() {
    }
    
    @Before
    public void setUp() throws ParseError {
        instance = new ExtInfoResponse(testString);
    }

    /**
     * Test of getPackageNum method, of class ExtInfoResponse.
     */
    @Test
    public void testGetPackageNum() {
        System.out.println("getPackageNum");
        int expResult = 1;
        int result = instance.getPackageNum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getResultCode method, of class ExtInfoResponse.
     */
    @Test
    public void testGetResultCode() {
        System.out.println("getResultCode");
        byte expResult = 0;
        byte result = instance.getResultCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardType method, of class ExtInfoResponse.
     */
    @Test
    public void testGetCardType() {
        System.out.println("getCardType");
        int expResult = 0;
        int result = instance.getCardType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardNumber method, of class ExtInfoResponse.
     */
    @Test
    public void testGetCardNumber() {
        System.out.println("getCardNumber");
        String expResult = "0000005056033120";
        String result = instance.getCardNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClientInfo method, of class ExtInfoResponse.
     */
    @Test
    public void testGetClientInfo() {
        System.out.println("getClientInfo");
        String expResult = "Цена клиента 38.50 р.";
        String result = instance.getClientInfo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClientType method, of class ExtInfoResponse.
     */
    @Test
    public void testGetClientType() {
        System.out.println("getClientType");
        int expResult = 0;
        int result = instance.getClientType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClientNum method, of class ExtInfoResponse.
     */
    @Test
    public void testGetClientNum() {
        System.out.println("getClientNum");
        int expResult = 0;
        int result = instance.getClientNum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardStartDate method, of class ExtInfoResponse.
     */
    @Test
    public void testGetCardStartDate() {
        System.out.println("getCardStartDate");
        Date expResult = null;
        Date result = instance.getCardStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardEndDate method, of class ExtInfoResponse.
     */
    @Test
    public void testGetCardEndDate() {
        System.out.println("getCardEndDate");
        Date expResult = null;
        Date result = instance.getCardEndDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBalance method, of class ExtInfoResponse.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        int expResult = 63713;
        int result = instance.getBalance();
        assertEquals(expResult, result);
    }
    
}
