/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.extinfo;

import ru.orengam.unipos.Limit;
import ru.orengam.unipos.WalletInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static ru.orengam.unipos.InfoMask.*;
import ru.orengam.unipos.ParseError;
import static ru.orengam.unipos.ResultCode.RC_OK;

/**
 *
 * @author vadim.shakirov
 */
public class ExtInfoResponse {
    
    private final Pattern pattern = Pattern.compile(
            "^a(\\d{4})"
            + "(\\d)"
            + "(\\d{4})"
            + "(\\d{16})"
            + "([0-9A-Fa-f]{4})"
            + "(\\d{2})");
    
    private int packageNum;
    private byte resultCode;
    private int cardType;    
    private String cardNumber;
    private int infoMask;
    private String clientInfo;
    private int clientType;
    private int clientNum;
    private Date cardStartDate;
    private Date cardEndDate;
    private int balance;
    private List<Limit> commonLimits;
    private List<WalletInfo> walletInfo;

    public ExtInfoResponse(String s) throws ParseError {
        Matcher m = pattern.matcher(s);
        if (m.find())
        {
            try {
                packageNum = Integer.valueOf(m.group(1));
                resultCode = Byte.valueOf(m.group(2));
                if (resultCode == RC_OK) {
                    cardType = Integer.valueOf(m.group(3));
                    cardNumber = m.group(4);
                    infoMask = Integer.parseInt(m.group(5), 16);
                    BufferedReader in = new BufferedReader(
                            new StringReader(s.substring(m.end(5))));

                    char[] cbuf;

                    if ((infoMask & IM_CLIENT_INFO) == IM_CLIENT_INFO) {
                        cbuf = new char[2];
                        in.read(cbuf, 0, 2);
                        byte clientInfoLength = Byte.valueOf(new String(cbuf));

                        cbuf = new char[clientInfoLength];
                        in.read(cbuf, 0, clientInfoLength);
                        clientInfo = new String(cbuf);
                    }

                    if ((infoMask & IM_CLIENT_TYPE) == IM_CLIENT_TYPE) {
                        cbuf = new char[3];
                        in.read(cbuf, 0, 3);
                        clientType = Integer.valueOf(new String(cbuf));
                    }

                    if ((infoMask & IM_CLIENT_NUM) == IM_CLIENT_NUM) {
                        cbuf = new char[10];
                        in.read(cbuf, 0, 10);
                        clientNum = Integer.valueOf(new String(cbuf));
                    }

                    if ((infoMask & IM_CARD_START_DATE) == IM_CARD_START_DATE) {
                        cbuf = new char[6];
                        DateFormat df = new SimpleDateFormat("ddMMyy");
                        in.read(cbuf, 0, 6);
                        cardStartDate = df.parse(new String(cbuf));
                    }

                    if ((infoMask & IM_CARD_END_DATE) == IM_CARD_END_DATE) {
                        cbuf = new char[6];
                        DateFormat df = new SimpleDateFormat("ddMMyy");
                        in.read(cbuf, 0, 6);
                        cardEndDate = df.parse(new String(cbuf));
                    }

                    if ((infoMask & IM_LIMIT) == IM_LIMIT) {
                        cbuf = new char[1];
                        in.read(cbuf, 0, 1);
                        byte limitCount = Byte.valueOf(new String(cbuf));
                        commonLimits = new ArrayList<>(limitCount);
                        for (byte i = 0; i < limitCount; i++) {
                            commonLimits.add(new Limit(in));
                        }
                    }

                    if ((infoMask & IM_BALANCE) == IM_BALANCE) {
                        cbuf = new char[10];
                        in.read(cbuf, 0, 10);
                        balance = Integer.valueOf(new String(cbuf));
                    }

                    cbuf = new char[2];
                    in.read(cbuf, 0, 2);
                    byte walletCount = Byte.valueOf(new String(cbuf));
                    walletInfo = new ArrayList<>(walletCount);
                    for (byte i = 0; i < walletCount; i++) {
                        walletInfo.add(new WalletInfo(in));
                    }
                } 
            } catch (IOException|ParseException ex) {
                throw new ParseError(ex.fillInStackTrace());         
            }
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
     * @return the resultCode
     */
    public byte getResultCode() {
        return resultCode;
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
     * @return the infoMask
     */
    public int getInfoMask() {
        return infoMask;
    }

    /**
     * @return the clientInfo
     */
    public String getClientInfo() {
        return clientInfo;
    }

    /**
     * @return the clientType
     */
    public int getClientType() {
        return clientType;
    }

    /**
     * @return the clientNum
     */
    public int getClientNum() {
        return clientNum;
    }

    /**
     * @return the cardStartDate
     */
    public Date getCardStartDate() {
        return cardStartDate;
    }

    /**
     * @return the cardEndDate
     */
    public Date getCardEndDate() {
        return cardEndDate;
    }

    /**
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @return the commonLimits
     */
    public List<Limit> getCommonLimits() {
        return commonLimits;
    }

    /**
     * @return the walletInfo
     */
    public List<WalletInfo> getWalletInfo() {
        return walletInfo;
    }
    
}
