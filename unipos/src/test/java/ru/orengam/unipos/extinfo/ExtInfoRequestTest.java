/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.extinfo;

import ru.orengam.unipos.extinfo.ExtInfoRequest;
import ru.orengam.unipos.InsertionFlag;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static ru.orengam.unipos.InfoMask.*;

/**
 *
 * @author vadim.shakirov
 */
public class ExtInfoRequestTest {
    
    private static final String TEST_STRING = "X0001100610300000000";
    private static final int PACKAGE_NUM = 1;
    private static final byte INSERT_FLAG = InsertionFlag.CARD_INSERT;
    private static final int INFO_MASK = IM_BALANCE 
            + IM_LIMIT + IM_CLIENT_INFO;
    private static final byte GOODS_CODE = 3;
    private static final int ATTR_MASK = 0;
    private static final byte WALLET_NUM = 0;
    
    private ExtInfoRequest instance;
    
    public ExtInfoRequestTest() {
    }
    
    @Before
    public void setUp() {
        instance = new ExtInfoRequest(PACKAGE_NUM, INSERT_FLAG, INFO_MASK, 
                GOODS_CODE, ATTR_MASK, WALLET_NUM);
    }

    /**
     * Test of getRequestData method, of class ExtInfoRequest.
     */
    @Test
    public void testGetRequestData() {
        System.out.println("getRequestData");
        String result = instance.getRequestData();
        assertEquals(TEST_STRING, result);
    }
    
}
