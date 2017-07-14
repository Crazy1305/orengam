/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.responses;

import java.text.ParseException;
import ru.orengam.entity.PumpList;
import ru.orengam.requests.RequestType;

/**
 *
 * @author vadim.shakirov
 */
public class GetPumpsResponse extends BaseResponse {
    
    public final PumpList pumps;
    
    public GetPumpsResponse(String source) throws ParseException {
        pumps = new PumpList(source);
    }

    @Override
    public RequestType getResponseType() {
        return RequestType.GET_PUMPS;
    }
    
}
