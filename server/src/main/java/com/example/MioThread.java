package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MioThread extends Thread{

    //creo il socket
    Socket s;

    //costruttore
    public MioThread(Socket s){
        this.s = s;
    }

    //implemento il metodo RUN
    public void run(){
        try {
            //INPUT E OUTPUT
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            do{
                String stringaRicevuta = in.readLine();
                
            //comparo la stringa ricevuta. Se è ! il client chiude ==> server chiude
            if(stringaRicevuta.equals("!")){
                System.out.println("Il client sta chiudendo");

                //chiudo il socket
                s.close();
                break;
            }

            //nomino il thread sul quale ho ricevuto
            System.out.println("Thread utilizzato: " + Thread.currentThread().getName() + " Stringa: " + stringaRicevuta);
            
            //trasformo la stringa in maiuscolo
            String stringaTrasformata = stringaRicevuta.toUpperCase();
            out.writeBytes(stringaTrasformata+ "\n");

            }while(true);
        
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
