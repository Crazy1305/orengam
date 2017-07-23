/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.entity;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vadim.shakirov
 */
public class Tank {
    public final int nTank;
    public final Petroleum petroleum;
    
    public Tank(int nTank, Petroleum petroleum) {
        this.nTank = nTank;
        this.petroleum = petroleum;
    }
    
    public Tank(String source) throws ParseException {
        Pattern p = Pattern.compile(getPattern());
        Matcher m = p.matcher(source);
        if (m.matches()) {
            nTank = Integer.valueOf(m.group(1));
            petroleum = new Petroleum(m.group(2));
        } 
        else throw new ParseException(source, 0);
    }
    
    public static String getPattern() {
        return "(\\d{4})" 
                + "(" + Petroleum.getPattern() + ")";
    }
    
    @Override
    public String toString() {
        return String.format("%04d%s", nTank, petroleum);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Tank) {
            Tank t = (Tank) o;
            return t.nTank == nTank && t.petroleum.equals(petroleum);
        }
        return false;
    }
    
}
