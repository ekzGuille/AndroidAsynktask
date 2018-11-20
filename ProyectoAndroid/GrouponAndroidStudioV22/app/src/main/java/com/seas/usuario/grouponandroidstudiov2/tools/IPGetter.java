package com.seas.usuario.grouponandroidstudiov2.tools;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPGetter {

    private static IPGetter clase;
    private InetAddress IP;

    private IPGetter() {
        try {
            IP = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static IPGetter getInstance(){
        if(clase == null){
            clase = new IPGetter();
        }
        return clase;
    }

    public InetAddress getIP() {
        return IP;
    }
}
