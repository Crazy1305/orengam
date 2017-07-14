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
public class Petroleum {
    public final int code;
    public final String caption;
    public final double priceCash;
    public final double priceCredit;
    
    public Petroleum(int code, String caption, double priceCash, double priceCredit) {
        this.code = code;
        this.caption = caption;
        this.priceCash = priceCash;
        this.priceCredit = priceCredit;
    }
    
    public Petroleum(String source) throws ParseException {
        Pattern p = Pattern.compile(getPattern());
        Matcher m = p.matcher(source);
        if (m.matches()) {
            code = Integer.valueOf(m.group(1));
            caption = m.group(2).trim();
            priceCash = Double.valueOf(m.group(3));
            priceCredit = Double.valueOf(m.group(4));
        }
        else throw new ParseException(source, 0);
    }
    
    public static String getPattern() {
        return "(\\d{4})"               //code
                //TODO уточнить размер названия нефтепродукта
                + "(.{20})"           //caption
                + "(\\d{6}.\\d{2})"     //priceCash
                + "(\\d{6}.\\d{2})";    //priceCredit
    }
    
    @Override
    public String toString() {
        //Locale.setDefault(Locale.US);
        return String.format("%04d%20s%09.2f%09.2f", code, caption, priceCash, priceCredit);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Petroleum) {
            Petroleum p = (Petroleum) o;
            return p.code == code && p.caption.equals(caption) &&
                    p.priceCash == priceCash && p.priceCredit == priceCredit;
        }
        return false;
    }
}
