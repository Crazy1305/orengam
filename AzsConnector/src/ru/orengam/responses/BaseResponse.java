/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.responses;

import java.text.ParseException;
import ru.orengam.requests.RequestType;

/**
 *
 * @author vadim.shakirov
 */
public abstract class BaseResponse {
    
    public static BaseResponse getBaseResponse(String source) throws ParseException {
        if (RequestType.values()[(int)source.charAt(0)] == RequestType.GET_PUMPS) {
            return new GetPumpsResponse(source.substring(1));
        } 
        throw new ClassCastException();
    }
    
    public abstract RequestType getResponseType();

}
