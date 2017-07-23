/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.entity;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vadim.shakirov
 */
public class PumpList {
    public Pump[] pumps;

    public PumpList(String source) throws ParseException {
        Pattern p = Pattern.compile(getPattern());
        Matcher m = p.matcher(source);
        if (m.matches()) {
            int pumpCount = Integer.valueOf(m.group(1));
            pumps = new Pump[pumpCount];
            Pattern pump = Pattern.compile(Pump.getPattern());
            Matcher pumpMatcher = pump.matcher(m.group(2));
            int i = 0;
            while (pumpMatcher.find()) {
                pumps[i] = new Pump(pumpMatcher.group());
                i++;
            }
            if (i != pumpCount) throw new ParseException(source, 0);
        }
    }
    
    public PumpList(Pump[] pumps) {
        this.pumps = pumps;
    }
    
    public static String getPattern() {
        return "^(\\d{2})"      // pumps count
                + "((" + Pump.getPattern() + ")"
                + "+)$";
    }
    
    @Override
    public String toString() {
        Locale.setDefault(Locale.US);
        String result = String.format("%02d", pumps.length);
        for (Pump pump : pumps) {
            result += pump.toString();
        }
        return result;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof PumpList) {
            PumpList list = (PumpList) o;
            return Arrays.equals(list.pumps, pumps);
        }
        return false;
    }
    
}
