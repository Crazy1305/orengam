/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.extdebit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.orengam.unipos.ParseError;
import static ru.orengam.unipos.ResultCode.*;

/**
 *
 * @author vadim.shakirov
 */
public class ExtDebitResponse {
        
    private final Pattern pattern = Pattern.compile(
            "^Y(\\d)"
            + "(\\d{4})"
            + "(\\d{16})"
            + "(\\d{20})"
            + "([+-]\\d{10})"
            + "([A-Za-z0-9][A-Z0-9]{4}\\d{5})"
            + "(\\d{2})?"
            + "(\\d{2})?"
            + "(\\d{8})?$");
    
    private int returnCode;
    private int cardType;
    private String cardNumber;
    private String Pan;
    private int balance;
    private String extReturnCode;
    private int rejectedCount;
    private int goodsCode;
    private int chequeNum;
    
    public ExtDebitResponse(String s) throws ParseError {
        Matcher m = pattern.matcher(s);
        if (m.matches())
        {
            returnCode = Integer.valueOf(m.group(1));
            cardType = Integer.valueOf(m.group(2));
            cardNumber = m.group(3);
            Pan = m.group(4);
            balance = Integer.valueOf(m.group(5));
            extReturnCode = m.group(6);
            if (returnCode == RC_ORDER_REJECTED) {
                rejectedCount = Integer.valueOf(m.group(7));
                goodsCode = Integer.valueOf(m.group(8));
            }
            if (returnCode == RC_OK) {
                chequeNum = Integer.valueOf(m.group(9));
            }
        } else {
            throw new ParseError();
        }
    }

    /**
     * @return the returnCode
     */
    public int getReturnCode() {
        return returnCode;
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
     * @return the Pan
     */
    public String getPan() {
        return Pan;
    }

    /**
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @return the rejectedCount
     */
    public int getRejectedCount() {
        return rejectedCount;
    }

    /**
     * @return the goodsCode
     */
    public int getGoodsCode() {
        return goodsCode;
    }

    /**
     * @return the extReturnCode
     */
    public String getExtReturnCode() {
        return extReturnCode;
    }

    /**
     * @return the chequeNum
     */
    public int getChequeNum() {
        return chequeNum;
    }
    
}
