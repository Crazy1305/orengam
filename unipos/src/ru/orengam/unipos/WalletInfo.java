/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vadim.shakirov
 */
public class WalletInfo {
        
    private final byte walletNum;
    private final byte attributeMask;
    private final int balance;
    private final int limit_top;
    private final int limit_bottom;
    private final byte limitType;
    private final boolean isPinProtected;
    private final int transactionCount;
    private final List<Limit> limits;
    private final List<Byte> services;
    
    
    public WalletInfo(BufferedReader in) throws ParseError {
        try {
            char[] buf = new char[2];
            in.read(buf, 0, 2);
            attributeMask = Byte.valueOf(new String(buf));

            buf = new char[11];
            in.read(buf, 0, 11);
            balance = Integer.valueOf(new String(buf));

            in.read(buf, 0, 11);
            limit_top = Integer.valueOf(new String(buf));

            in.read(buf, 0, 11);
            limit_bottom = Integer.valueOf(new String(buf));

            buf = new char[1];
            in.read(buf, 0, 1);
            limitType = Byte.valueOf(new String(buf));

            buf = new char[1];
            in.read(buf, 0, 1);
            byte limitCount = Byte.valueOf(new String(buf));
            limits = new ArrayList<>(limitCount);
            for (byte i = 0; i < limitCount; i++) {
                limits.add(new Limit(in));
            }

            in.read(buf, 0, 1);
            isPinProtected = (buf[0] == '1');

            in.read(buf, 0, 1);
            byte serviceCount = Byte.valueOf(new String(buf));

            buf = new char[2];
            in.read(buf, 0, 2);
            walletNum = Byte.valueOf(new String(buf));

            buf = new char[1];
            services = new ArrayList<>(serviceCount);
            for (byte i = 0; i < serviceCount; i++) {
                in.read(buf, 0, 1);
                services.add(Byte.valueOf(new String(buf)));
            }

            buf = new char[5];
            in.read(buf, 0, 5);
            transactionCount = Integer.valueOf(new String(buf));
        } catch (IOException ex) {
            throw new ParseError(ex.fillInStackTrace());
        }
    }

    /**
     * Маска полученных атрибутов кошелька
     * @return the attributeMask
     */
    public byte getAttributeMask() {
        return attributeMask;
    }

    /**
     * Баланс кошелька
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Верхняя граница кошелька
     * @return the limit_top
     */
    public int getLimit_top() {
        return limit_top;
    }

    /**
     * Нижняя граница кошелька
     * @return the limit_bottom
     */
    public int getLimit_bottom() {
        return limit_bottom;
    }

    /**
     * Принадлежность лимитов
     * 0 - индивидуальные лимиты, 
     * 1 - кошелек связан с общими лимитами 
     * @return the limitType
     */
    public byte getLimitType() {
        return limitType;
    }

    /**
     * Лимиты кошелька
     * @return the limits
     * @see Limit
     */
    public List<Limit> getLimits() {
        return limits;
    }

    /**
     * Защищенность по PIN
     * @return the isPinProtected
     */
    public boolean isIsPinProtected() {
        return isPinProtected;
    }

    /**
     * Номер кошелька
     * @return the walletNum
     */
    public byte getWalletNum() {
        return walletNum;
    }

    /**
     * Список локальных номеров услуг на кошельке
     * @return the services
     */
    public List<Byte> getServices() {
        return services;
    }

    /**
     * Количество транзакций по кошельку
     * @return the transactionCount
     */
    public int getTransactionCount() {
        return transactionCount;
    }
}
