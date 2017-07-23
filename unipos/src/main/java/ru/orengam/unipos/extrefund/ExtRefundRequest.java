/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.extrefund;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static ru.orengam.unipos.InsertionFlag.*;

/**
 *
 * @author vadim.shakirov
 */
public class ExtRefundRequest {
    
    private final int packageNum;
    private byte insertionFlag;
    private final byte refundType;
    private final int cardType;
    private final int cardTypeParam;
    private final String cardNum;
    private final int chequeNum;
    private final long amount;
    private final int count;
    private final int code;
    private final Date debitDate;
    
    private static final String TEMPLATE = "V%04d0%01d%01dR%04d%03d%10s%08d%010d%08d%02d%6s";
    
    public ExtRefundRequest (
            int packageNum, 
            byte insertionFlag,
            byte refundType,
            int cardType,
            int cardTypeParam,
            String cardNum,
            int chequeNum,
            double amount,
            double count,
            int code,
            Date debitDate)
    {
        this.packageNum = packageNum; 
        this.insertionFlag = 0;
        if ((CARD_INSERT & insertionFlag) == CARD_INSERT)
            this.insertionFlag += 1;
        if ((CARD_REMOVE & insertionFlag) == CARD_REMOVE)
            this.insertionFlag += 2;
        this.refundType = refundType;
        this.cardType = cardType;
        this.cardTypeParam = cardTypeParam;
        this.cardNum = cardNum;
        this.chequeNum = chequeNum;
        this.amount = (long)(amount*100);
        this.count = (int)(count*100);
        this.code = code;
        this.debitDate = debitDate;
    }
    
    public String getRequestData() {
        DateFormat df = new SimpleDateFormat("ddMMyy");
        String s = String.format(TEMPLATE, 
                packageNum, 
                insertionFlag,
                refundType,
                cardType,
                cardTypeParam,
                cardNum,
                chequeNum,
                amount,
                count,
                code,
                df.format(debitDate));
        return s;
    }
    
}
