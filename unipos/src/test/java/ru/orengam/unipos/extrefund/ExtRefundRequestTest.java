/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.extrefund;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static ru.orengam.unipos.InsertionFlag.*;
import static ru.orengam.unipos.RefundType.*;

/**
 *
 * @author vadim.shakirov
 */
public class ExtRefundRequestTest {
    
    private ExtRefundRequest instance;
    
    public ExtRefundRequestTest() {
    }
    
    @Before
    public void setUp() {
        String cardNum = "0000000056030913";
        instance = new ExtRefundRequest(1, (byte)(CARD_INSERT|CARD_REMOVE), RT_CARD, 1, 999, cardNum, 0, 39999999.99, 999999.99, 99, new Date());
    }

    /**
     * Test of getRequestData method, of class ExtRefundRequest.
     */
    @Test
    public void testGetRequestData() {
        System.out.println("getRequestData");
        DateFormat df = new SimpleDateFormat("ddMMyy");
        String expResult = "V0001031R000199900000000560309130000000039999999999999999999" + df.format(new Date());
        String result = instance.getRequestData();
        assertEquals(expResult, result);
    }
    
}
