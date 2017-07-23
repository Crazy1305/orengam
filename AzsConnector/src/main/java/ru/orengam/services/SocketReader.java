/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import ru.orengam.entity.PumpList;
import ru.orengam.responses.BaseResponse;
import ru.orengam.responses.GetPumpsResponse;

/**
 *
 * @author vadim.shakirov
 */
public class SocketReader {
    
    public final PumpList pl;
    
    public SocketReader(InputStream in) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        BaseResponse br = BaseResponse.getBaseResponse(reader.readLine());
        switch (br.getResponseType()) {
            case GET_PUMPS : {
                pl = ((GetPumpsResponse) br).pumps;
                break;
            }
            default : pl = null;
        }
        
    }

}
