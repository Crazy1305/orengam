/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.requests;

/**
 *
 * @author vadim.shakirov
 */
public enum RequestType {
    GET_PUMPS,
    LOCK_PUMP,
    UNLOCK_PUMP,
    START_FUELING,
    GET_COUNTER;
    
    public static RequestType getRequestType(byte i) {
        return RequestType.values()[i];
    }
}
