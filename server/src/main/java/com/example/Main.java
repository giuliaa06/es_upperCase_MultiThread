package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("server avviato");

        // creo il server e dico quale porta devo aprire
        ServerSocket ss = new ServerSocket(3000);

        // creo un ciclo do while come nel client
        do {

            // metto il server in ascolto
            Socket s = ss.accept();
            System.out.println("Un client si è collegato");

            // creo un Thread per permettere a piu client di collegarsi e porto la socket
            MioThread t = new MioThread(s);

            // faccio partire il Thread
            t.start();
        } while (true);
    }

}