/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.services;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.ParseException;
import ru.orengam.entity.PumpList;
import ru.orengam.requests.BaseRequest;

/**
 *
 * @author vadim.shakirov
 */
public class SocketClient {
    private static final String ADDRESS = "127.0.0.1";
    private static final int PORT = 5555;
    
    public static PumpList getPumps() throws IOException, ParseException {
        try (Socket socket = new Socket(ADDRESS, PORT)) {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(BaseRequest.getPumpsRequest().toString());
            out.flush();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            return new PumpList(in.readUTF());
        }
    }
    
}
