/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.extrefund;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.orengam.unipos.ParseError;

/**
 *
 * @author vadim.shakirov
 */
public class ExtRefundResponse {
    private final Pattern pattern = Pattern.compile(
            "^S(\\d{4})"
            + "(\\d)"
            + "(\\d{2})"
            + "(\\d{4})"
            + "(\\d{16})"
            + "(\\d{3})"
            + "([+-]\\d{10})"
            + "([+-]\\d{10})"
            + "([A-Za-z0-9][A-Z0-9]{4}\\d{5})$");
    
    private int packageNum;
    private byte refundCode;
    private byte refundType;
    private int cardType;
    private String cardNumber;
    private int rfu;
    private int balanceBefore;
    private int balanceAfter;
    private String extReturnCode;
    
    public ExtRefundResponse(String s) throws ParseError {
        Matcher m = pattern.matcher(s);
        if (m.matches())
        {
            packageNum = Integer.valueOf(m.group(1));
            refundCode = Byte.valueOf(m.group(2));
            refundType = Byte.valueOf(m.group(3));
            cardType = Integer.valueOf(m.group(4));
            cardNumber = m.group(5);
            rfu =  Integer.valueOf(m.group(6));
            balanceBefore = Integer.valueOf(m.group(7));
            balanceAfter = Integer.valueOf(m.group(8));
            extReturnCode = m.group(9);
        } else {
            throw new ParseError();
        }
    }

    /**
     * @return the packageNum
     */
    public int getPackageNum() {
        return packageNum;
    }

    /**
     * @return the refundCode
     */
    public byte getRefundCode() {
        return refundCode;
    }

    /**
     * @return the refundType
     */
    public byte getRefundType() {
        return refundType;
    }

    /**
     * @return the cardType
     */
    public int getCardType() {
        return cardType;
    }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * @return the rfu
     */
    public int getRfu() {
        return rfu;
    }

    /**
     * @return the balanceBefore
     */
    public int getBalanceBefore() {
        return balanceBefore;
    }

    /**
     * @return the balanceAfter
     */
    public int getBalanceAfter() {
        return balanceAfter;
    }

    /**
     * @return the extReturnCode
     */
    public String getExtReturnCode() {
        return extReturnCode;
    }
}
