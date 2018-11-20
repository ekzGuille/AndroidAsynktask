package com.seas.usuario.grouponandroidstudiov2.tools;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPGetter {

    private static IPGetter clase;
    final static String IP_LOCAL_SERVIDOR = "192.168.20.129";
//    private InetAddress IP;

    private IPGetter() {
//        try {
//            IP = InetAddress.getLocalHost();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
    }

    public static IPGetter getInstance(){
        if(clase == null){
            clase = new IPGetter();
        }
        return clase;
    }

//    public InetAddress getIP() {
//        return IP;
//    }

    public String getIP(){
        return IP_LOCAL_SERVIDOR;
    }
}
