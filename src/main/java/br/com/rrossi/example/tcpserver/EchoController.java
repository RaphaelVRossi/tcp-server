package br.com.rrossi.example.tcpserver;

/**
 * Criado por Raphael em 01/10/2019.
 */
@TcpController
public class EchoController {
    public void receiveData(Connection connection, byte[] data) {
        String s = new String(data);
        System.out.println("SENDDDD " + s);

        connection.send(s.toUpperCase().getBytes());
    }

    public void connect(Connection connection) {
        System.out.println("New connection " + connection.getAddress().getCanonicalHostName());
    }

    public void disconnect(Connection connection) {
        System.out.println("Disconnect " + connection.getAddress().getCanonicalHostName());
    }
}

0010001000010000000000000001000100000010110000000100100000000100


48564848504848484849484848486748484848505148484848484852534949494949494949505050505050505050505050505050485050841041051153210511532973284101115116327710111511597103101