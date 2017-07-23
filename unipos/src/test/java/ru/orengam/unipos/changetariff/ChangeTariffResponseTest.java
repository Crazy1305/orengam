/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.changetariff;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.orengam.unipos.ParseError;

/**
 *
 * @author vadim.shakirov
 */
public class ChangeTariffResponseTest {
    
    private static ChangeTariffResponse instance;
    private static String s = "U000200111110320000361003200003610";
    
    public ChangeTariffResponseTest() {
    }
    
    @Before
    public void setUp() throws ParseError {
        instance = new ChangeTariffResponse(s);
    }

    /**
     * Test of getPackageNum method, of class ChangeTariffResponse.
     */
    @Test
    public void testGetPackageNum() {
        int expResult = 2;
        int result = instance.getPackageNum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getReturnCode method, of class ChangeTariffResponse.
     */
    @Test
    public void testGetReturnCode() {
        int expResult = 0;
        int result = instance.getResultCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCode method, of class ChangeTariffResponse.
     */
    @Test
    public void testGetCode() {
        int expResult = 3;
        int result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class ChangeTariffResponse.
     */
    @Test
    public void testGetPrice() {
        int expResult = 3610;
        int result = instance.getPrice();
        assertEquals(expResult, result);
    }
    
}
