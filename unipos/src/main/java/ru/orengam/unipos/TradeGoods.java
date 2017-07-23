/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos;

/**
 *
 * @author vadim.shakirov
 */
public class TradeGoods {
    private int count;
    private double cost;
    private int code;

    public TradeGoods(
            double cost,
            int count,
            int code) 
    {
        this.cost = cost;
        this.count = count;
        this.code = code;
    }
    
    public int getCount() { return count; }
    public int getCost() { return (int)(cost * 100); }
    public int getCode() { return code; }
    
}
