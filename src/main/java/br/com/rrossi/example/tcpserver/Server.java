package br.com.rrossi.example.tcpserver;

import java.util.List;

/**
 * Criado por Raphael em 01/10/2019.
 */
public interface Server {
    int getConnectionsCount();
    void setPort(Integer port);
    void start();
    void stop();
    List<Connection> getConnections();
    void addListener(Connection.Listener listener);
}
