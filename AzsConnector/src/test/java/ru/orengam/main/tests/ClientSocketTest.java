/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.orengam.main.tests;

import java.awt.AlphaComposite;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.orengam.entity.Nozzle;
import ru.orengam.entity.Petroleum;
import ru.orengam.entity.Pump;
import ru.orengam.entity.PumpList;
import ru.orengam.entity.Tank;
import ru.orengam.requests.RequestType;
import ru.orengam.services.SocketClient;

/**
 *
 * @author vadim.shakirov
 */
public class ClientSocketTest {
    
    private PumpList pumplist;
    private SocketServer sr;
    Thread t;
    
    private class SocketServer extends Thread {
        private final ServerSocket socket;
        private Socket ss;
        
        
        public SocketServer() throws IOException {
            socket = new ServerSocket(5555);
        }
        
        @Override
        public void run() {
            DataInputStream in = null;
            try {
                ss = socket.accept();
                in = new DataInputStream(ss.getInputStream());
                while (true) {
                    String line = in.readUTF();
                    if (RequestType.getRequestType(Byte.valueOf(line.substring(0, 1)))
                            == RequestType.GET_PUMPS) {
                        DataOutputStream out = new DataOutputStream(ss.getOutputStream());
                        out.writeUTF(pumplist.toString());
                        out.flush();
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientSocketTest.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClientSocketTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @Before
    public void setUp() throws IOException {
        sr = new SocketServer();
        t = new Thread(sr);
        t.start();
        Tank tank1 = new Tank(1, new Petroleum(8, "Пропан", 18, 18));
        Tank tank2 = new Tank(2, new Petroleum(9, "Метан", 14, 12));
        Nozzle noz1 = new Nozzle((byte)1, tank1, 100, 100);
        Nozzle noz2 = new Nozzle((byte)2, tank2, 100, 100);
        Nozzle[] nozzles = {noz1, noz2};
        Pump pump = new Pump((byte) 1, nozzles);
        Pump[] pumps = new Pump[3];
        Arrays.fill(pumps, pump);
        pumplist = new PumpList(pumps);
        
    }
    
    @Test
    public void hello() throws IOException, ParseException {
        PumpList pl = SocketClient.getPumps();
        t.interrupt();
        pl.toString();
        assertEquals(pumplist, pl);
    }
}
