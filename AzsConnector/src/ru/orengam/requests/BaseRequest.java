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
public class BaseRequest {
    public final RequestType type;
    public final String data;
    
    private BaseRequest(RequestType type, String data) {
        this.type = type;
        this.data = data;
    }
    
    @Override
    public String toString() {
        return type.ordinal() + data;
    }
    
    public static BaseRequest getPumpsRequest() {
        return new BaseRequest(RequestType.GET_PUMPS, "");
    }
    
}
