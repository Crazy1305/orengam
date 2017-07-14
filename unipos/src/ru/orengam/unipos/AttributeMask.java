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
public final class AttributeMask {
    public static final int AM_BALANCE      = 0b00000001;
    public static final int AM_LIMIT_TOP    = 0b00000010;
    public static final int AM_LIMIT_BOTTOM = 0b00000100;
    public static final int AM_LIMIT_TYPE   = 0b00001000;
    public static final int AM_LIMIT        = 0b00010000;
    public static final int AM_PIN          = 0b00100000;
    public static final int AM_WALLET_NUM   = 0b01000000;
    public static final int AM_TRAN_COUNT   = 0b10000000;    
}
