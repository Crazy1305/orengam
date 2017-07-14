/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.responses;

import ru.orengam.requests.RequestType;

/**
 *
 * @author vadim.shakirov
 */
public class PumpStartResponse extends BaseResponse {

    @Override
    public RequestType getResponseType() {
        return RequestType.START_FUELING;
    }
    
}
