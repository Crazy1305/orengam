/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vadim.shakirov
 */
public final class ExtResultCode {
    
    private final Pattern pattern = Pattern.compile("^([0-9A-Za-z])([0-9A-Z]{4})(\\d{4})0$");
    
    private byte ExtSystemAttr;
    private String originResultCode;
    private int ExtResultCode;
    
    public final int ERC_OK = 0;
    public final int ERC_UNSUFFICIENT_BALANCE = 1;
    public final int ERC_CANCELED_BY_OPERATOR = 2;
    public final int ERC_CARD_IN_BLACK_LIST = 3;
    public final int ERC_CARD_EXPIRED = 4;
    public final int ERC_CARD_NOT_STARTED = 5;
    public final int ERC_RESET_ERROR = 6;
    public final int ERC_CARD_NOT_READED = 7;
    public final int ERC_ACCESS_ERROR = 8;
    public final int ERC_AMOUNT_ERROR = 9;
    public final int ERC_ORDER_REJECTED = 11;
    public final int ERC_OPERATION_CANCELED = 12;
    //magnetic card extended codes
    public final int ERC_CONNECTION_ERROR = 14;
    public final int ERC_SCRIPT_EXEC_ERROR = 15;
    public final int ERC_DATA_EXCHANGE_ERROR = 16;
    public final int ERC_PAN_IS_ABSENT = 17;
    public final int ERC_WRONG_OPERATION = 18;
    public final int ERC_TRACK2_NOT_FOUND = 19;
    public final int ERC_TRACK_TABLE_FULL = 20;
    public final int ERC_TARIFF_NOT_SPECIFIED = 21;
    public final int ERC_WRONG_WALLET = 22;
    public final int ERC_LINK_IS_ABSENT = 23;
    public final int ERC_AUTH_CODE_IS_ABSENT = 24;
    public final int ERC_RECIEPT_NUM_IS_ABSENT = 25;
    public final int ERC_TRANSACTION_NOT_FOUND = 26;
    public final int ERC_MAGNET_LOG_IS_FULL = 27;
    
    
    public ExtResultCode(String s) throws ParseError {
        Matcher m = pattern.matcher(s);
        if (m.matches()) {
            ExtSystemAttr = Byte.valueOf(m.group(1));
            originResultCode = m.group(2);
            ExtResultCode = Byte.valueOf(m.group(3));
        } else {
            throw new ParseError();
        }
    }

    /**
     * @return the ExtSystemAttr
     */
    public byte getExtSystemAttr() {
        return ExtSystemAttr;
    }

    /**
     * @return the originResultCode
     */
    public String getOriginResultCode() {
        return originResultCode;
    }

    /**
     * @return the ExtResultCode
     */
    public int getExtResultCode() {
        return ExtResultCode;
    }
    
}
