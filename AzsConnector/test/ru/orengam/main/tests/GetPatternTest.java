/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.main.tests;

import java.text.ParseException;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.orengam.entity.Nozzle;
import ru.orengam.entity.Petroleum;
import ru.orengam.entity.Pump;
import ru.orengam.entity.Tank;
import ru.orengam.entity.PumpList;

/**
 *
 * @author vadim.shakirov
 */
public class GetPatternTest {
    
    PumpList m;
    
    public GetPatternTest() {
    }
    
    @Before
    public void setUp() {
        Tank tank1 = new Tank(1, new Petroleum(8, "Пропан", 18, 18));
        Tank tank2 = new Tank(2, new Petroleum(9, "Метан", 14, 12));
        Nozzle noz1 = new Nozzle((byte)1, tank1, 100, 100);
        Nozzle noz2 = new Nozzle((byte)2, tank2, 100, 100);
        Nozzle[] nozzles = {noz1, noz2};
        Pump pump = new Pump((byte) 1, nozzles);
        Pump[] pumps = new Pump[3];
        Arrays.fill(pumps, pump);
        m = new PumpList(pumps);
    }

    @Test
    public void getPatternString() {
        String s = PumpList.getPattern();
        String e = "^(\\d{2})(((\\d{4})(\\d{4})(((\\d{4})(\\d{6}.\\d{4})(\\d{6}.\\d{4})((\\d{4})((\\d{4})(.{20})(\\d{6}.\\d{2})(\\d{6}.\\d{2}))))+))+)$";
        System.out.println(PumpList.getPattern());
        Assert.assertEquals(s, e);
    }
    
    @Test
    public void testManager() throws ParseException {
        String source = m.toString();
        PumpList m2 = new PumpList(source);
        Assert.assertEquals(m2, m);
    }
}
