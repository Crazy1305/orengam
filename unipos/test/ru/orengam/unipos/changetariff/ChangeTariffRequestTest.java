/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.changetariff;

import ru.orengam.unipos.changetariff.ChangeTariffRequest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vadim.shakirov
 */
public class ChangeTariffRequestTest {
    ChangeTariffRequest instance = null;
    
    public ChangeTariffRequestTest() {
    }
    
    @Before
    public void setUp() {
        instance = new ChangeTariffRequest(2, 3, 36.10);
    }

    /**
     * Test of getRequestData method, of class ExtDebitRequest.
     */
    @Test
    public void testGetRequestData() {
        System.out.println("getRequestData");
        
        String expResult = "T0002011103200003610";
        String result = instance.getRequestData();
        assertEquals(expResult, result);
    }
    
}
