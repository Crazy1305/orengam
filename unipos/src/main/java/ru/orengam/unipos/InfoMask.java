/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.unipos;

/**
 *
 * @author vadim.shakirov
 */
public final class InfoMask {
    public static final int IM_CLIENT_INFO       = 0b0000001;
    public static final int IM_CLIENT_TYPE       = 0b0000010;
    public static final int IM_CLIENT_NUM        = 0b0000100;
    public static final int IM_CARD_START_DATE   = 0b0001000;
    public static final int IM_CARD_END_DATE     = 0b0010000;
    public static final int IM_LIMIT             = 0b0100000;
    public static final int IM_BALANCE           = 0b1000000;    
}
