/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos.extinfo;

import static ru.orengam.unipos.InsertionFlag.*;

/**
 *
 * @author vadim.shakirov
 */

/*
09:20:32;I;7;;;0;recv: X0001100610300000000 packetnum: 0001
09:20:32;I;7;;;0;UID = 2 pkg<InfoExt: #1 fc: InsertNotExtract gooid: 3 MaskInfo: 97 MaskAttrPurse: 0 MaskPurse: 0>
09:20:33;I;7;;;0;send = a0001000000000005056033120006121Цена клиента 38.50 р.2120061700099999000009999900020061700099999000009999900000006371300
*/

public class ExtInfoRequest {
    
    private final int packageNum;
    private byte insertionFlag;
    private final int infoMask;
    private final byte goodsCode;
    private final int attributeMask;
    private final int walletMask;
    
    
    private static final String TEMPLATE = "X%04d%1d%04X%02d%02X%06X";
    
    public ExtInfoRequest(int packageNum, byte insertionFlag, int infoMask, byte goodsCode, int attributeMask, byte walletNum) {
        this.packageNum = packageNum;
        this.insertionFlag = 0;
        if ((CARD_INSERT & insertionFlag) == CARD_INSERT)
            this.insertionFlag += 1;
        if ((CARD_REMOVE & insertionFlag) == CARD_REMOVE)
            this.insertionFlag += 2;
        this.infoMask = infoMask;
        this.goodsCode = goodsCode;
        this.attributeMask = attributeMask;
        this.walletMask = walletNum == 0 ? 0 : 1 << walletNum - 1;
    }
    
    public String getRequestData() {
        String s = String.format(TEMPLATE, 
                packageNum,
                insertionFlag,
                infoMask,
                goodsCode,
                attributeMask,
                walletMask);
        return s;
    }
    
            
    
}
