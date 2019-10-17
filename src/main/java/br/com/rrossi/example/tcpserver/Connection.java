package br.com.rrossi.example.tcpserver;

import java.net.InetAddress;

/**
 * Criado por Raphael em 01/10/2019.
 */
public interface Connection {
    InetAddress getAddress();
    void send(Object objectToSend);
    void addListener(Listener listener);
    void start();
    void close();

    interface Listener {
        void messageReceived(Connection connection, Object message);
        void connected(Connection connection);
        void disconnected(Connection connection);
    }
}