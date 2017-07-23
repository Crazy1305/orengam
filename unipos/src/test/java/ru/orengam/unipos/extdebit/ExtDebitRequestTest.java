/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.extdebit;

import ru.orengam.unipos.extdebit.ExtDebitRequest;
import ru.orengam.unipos.InsertionFlag;
import ru.orengam.unipos.TradeGoods;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vadim.shakirov
 */
public class ExtDebitRequestTest {
    ExtDebitRequest instance = null;
    
    public ExtDebitRequestTest() {
    }
    
    @Before
    public void setUp() {
        List<TradeGoods> goods = new ArrayList<>();
        goods.add(new TradeGoods(0, 1500, 3));
        instance = new ExtDebitRequest(3, 0, 0, InsertionFlag.CARD_INSERT, goods);
    }

    /**
     * Test of getRequestData method, of class ExtDebitRequest.
     */
    @Test
    public void testGetRequestData() {
        System.out.println("getRequestData");
        
        String expResult = "Q00030000000011000000000000000150003";
        String result = instance.getRequestData();
        assertEquals(expResult, result);
    }
    
}
