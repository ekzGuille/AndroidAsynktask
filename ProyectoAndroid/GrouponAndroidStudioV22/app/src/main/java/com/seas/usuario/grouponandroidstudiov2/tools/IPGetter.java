package com.seas.usuario.grouponandroidstudiov2.tools;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPGetter {

    private static IPGetter clase;
    final static String IP_LOCAL_SERVIDOR = "192.168.20.129";

    private IPGetter() {
    }

    public static IPGetter getInstance(){
        if(clase == null){
            clase = new IPGetter();
        }
        return clase;
    }

    public String getIP(){
        return IP_LOCAL_SERVIDOR;
    }
}
