/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vadim.shakirov
 */
public class Limit {

    private final byte limitType;
    private final Date updateDate;
    private final int maxLimit;
    private final int currentLimit;

    public Limit(BufferedReader in) throws ParseError {
        try {
            char[] buf = new char[1];
            in.read(buf, 0, 1);
            limitType = Byte.valueOf(new String(buf));

            buf = new char[6];
            DateFormat df = new SimpleDateFormat("ddMMyy");
            in.read(buf, 0, 6);
            updateDate = df.parse(new String(buf));

            buf = new char[10];
            in.read(buf, 0, 10);
            maxLimit = Integer.valueOf(new String(buf));

            in.read(buf, 0, 10);
            currentLimit = Integer.valueOf(new String(buf));
        } catch (IOException|ParseException ex) {
            throw new ParseError(ex.fillInStackTrace());
        }
    }

    /**
     * Тип лимита
     * 0 - месячный, 1 - суточный, остальное - RFU
     * @return the limitType
     */
    public byte getLimitType() {
        return limitType;
    }

    /**
     * Дата изменения лимита
     * @return the updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * Максимальный лимит
     * @return the maxLimit
     */
    public int getMaxLimit() {
        return maxLimit;
    }

    /**
     * Текущий лимит
     * @return the currentLimit
     */
    public int getCurrentLimit() {
        return currentLimit;
    }
}
