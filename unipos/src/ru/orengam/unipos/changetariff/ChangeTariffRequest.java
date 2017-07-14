/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.changetariff;

/**
 *
 * @author vadim.shakirov
 */
public class ChangeTariffRequest {
    private final int packageNum;
    private final int code;
    private final int price;
    
    private static final String TEMPLATE = "T%04d0111%02d2%08d";
    
    public ChangeTariffRequest (
            int packageNum, 
            int code, 
            double price) 
    {
        this.packageNum = packageNum;
        this.code = code;
        this.price = (int)(price * 100);
    }
    
    public String getRequestData() {
        String s = String.format(TEMPLATE, 
                packageNum, 
                code, 
                price);
        return s;
    }
}
