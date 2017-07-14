/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.changetariff;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.orengam.unipos.ParseError;

/**
 *
 * @author vadim.shakirov
 */
public class ChangeTariffResponse {
    private final Pattern pattern = Pattern.compile(
            "^U(\\d{4})"
            + "(\\d{1})"
            + "011111"
            + "\\d{11}"
            + "(\\d{2})"
            + "\\d"
            + "(\\d{8})$");
    
    private int packageNum;
    private int resultCode;
    private int code;
    private int price;
    
    public ChangeTariffResponse(String s) throws ParseError {
        Matcher m = pattern.matcher(s);
        if (m.matches())
        {
            packageNum = Integer.valueOf(m.group(1));
            resultCode = Integer.valueOf(m.group(2));
            code = Integer.valueOf(m.group(3));
            price = Integer.valueOf(m.group(4));
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
     * @return the returnCode
     */
    public int getResultCode() {
        return resultCode;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }
}
