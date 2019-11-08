package br.com.rrossi.example.tcpclient;

import br.com.rrossi.example.tcpserver.TcpServerApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Criado por Raphael em 29/10/2019.
 */
@SpringBootApplication
public class TcpClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcpClientApplication.class, args);
    }

}
