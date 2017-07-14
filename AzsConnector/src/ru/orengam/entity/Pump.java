/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.entity;

import java.text.ParseException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vadim.shakirov
 */
public class Pump {
    public final byte nPump;
    public final Nozzle[] nozzles;
    
    public Pump(byte nPump, Nozzle[] nozzles) {
        this.nPump = nPump;
        this.nozzles = nozzles;
    }
    
    public Pump(String source) throws ParseException {
        Pattern p = Pattern.compile(getPattern());
        Matcher m = p.matcher(source);
        if (m.matches()) {
            nPump = Byte.valueOf(m.group(1));
            int nozzlesCount = Integer.valueOf(m.group(2));
            nozzles = new Nozzle[nozzlesCount];
            Pattern nozzlePattern = Pattern.compile(Nozzle.getPattern());
            Matcher nozzleMatcher = nozzlePattern.matcher(m.group(3));
            int i = 0;
            while (nozzleMatcher.find()) {
                nozzles[i] = new Nozzle(nozzleMatcher.group());
                i++;
            }
            if (i != nozzlesCount) throw new ParseException(source, 0);
        }
        else throw new ParseException(source, 0);
    }
    
    public static String getPattern() {
        return "(\\d{4})"       // nPump
                + "(\\d{4})"    // nozzlesCount
                + "((" + Nozzle.getPattern() + ")+)";
    }
    
    @Override
    public String toString() {
        String result = String.format("%04d%04d", nPump, nozzles.length);
        for (Nozzle nozzle : nozzles) {
            result += nozzle.toString();
        }
        return result;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Pump) {
            Pump pump = (Pump) o;
            return (pump.nPump == nPump) && Arrays.equals(pump.nozzles, nozzles);
        }
        return false;
    }
}
