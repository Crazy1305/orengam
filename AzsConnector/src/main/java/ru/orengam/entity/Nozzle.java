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
public class Nozzle {
    public final byte nNozzle;
    public final Tank tank;
    public double discretness;
    public double endCounter;
    
    public Nozzle(byte nNozzle, Tank tank, double discretness, double endCounter) {
        this.nNozzle = nNozzle;
        this.tank = tank;
        this.discretness = discretness;
        this.endCounter = endCounter;
    }
    
    public Nozzle(String source) throws ParseException {
        Pattern p = Pattern.compile(getPattern());
        Matcher m = p.matcher(source);
        if (m.matches()) {
            nNozzle = Byte.valueOf(m.group(1));
            discretness = Double.valueOf(m.group(2));
            endCounter = Double.valueOf(m.group(3));
            tank = new Tank(m.group(4));
        }
        else throw new ParseException(source, 0);
    }

    
    public static String getPattern() {
        return "(\\d{4})"               // nNozzle
                + "(\\d{6}.\\d{4})"     // discretness
                + "(\\d{6}.\\d{4})"     // endCounter
                + "(" + Tank.getPattern() + ")";
    }
    
    @Override
    public String toString(){
        return String.format("%04d%011.4f%011.4f%s", nNozzle, discretness, endCounter, tank);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Nozzle) {
            Nozzle n = (Nozzle) o;
            return (n.nNozzle == nNozzle) && (n.tank.equals(tank)) &&
                    (n.discretness == discretness) && (n.endCounter == endCounter);
        }
        return  false;
    }
}
