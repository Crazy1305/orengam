/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.extdebit;

import ru.orengam.unipos.TradeGoods;
import java.util.ArrayList;
import java.util.List;
import static ru.orengam.unipos.InsertionFlag.*;

/**
 *
 * @author vadim.shakirov
 */
public class ExtDebitRequest {
    private final int packageNum;
    private final int cardType;
    private final int cardTypeParam;
    private int insertionFlag;
    private final List<TradeGoods> goods;
    
    private static final String TEMPLATE = "Q%04d%04d%03d%02d%01d%011d%08d%02d";
    private static final String ADD_GOODS = "%011d%08d%02d";
    
    public ExtDebitRequest (
            int packageNum, 
            int cardType, 
            int cardTypeParam,
            int flag, 
            List<TradeGoods> goods) 
    {
        insertionFlag = 0;
        if ((CARD_INSERT & flag) == CARD_INSERT)
            insertionFlag += 1;
        if ((CARD_REMOVE & flag) == CARD_REMOVE)
            insertionFlag += 2;
        this.packageNum = packageNum;
        this.cardType = cardType;
        this.cardTypeParam = cardTypeParam;
        this.goods = new ArrayList<>(goods);
    }
    
    public String getRequestData() {
        String s = String.format(TEMPLATE, 
                packageNum, 
                cardType, 
                cardTypeParam,
                goods.size(), 
                insertionFlag,
                goods.get(0).getCost(),
                goods.get(0).getCount(),
                goods.get(0).getCode());
        for (int i = 1; i < goods.size(); i++)
        {
            s += String.format(ADD_GOODS, 
                goods.get(i).getCost(),
                goods.get(i).getCount(),
                goods.get(i).getCode());
        }
        return s;
    }
}
