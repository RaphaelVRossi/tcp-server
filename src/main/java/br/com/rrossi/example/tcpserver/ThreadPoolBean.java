package br.com.rrossi.example.tcpserver;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Criado por Raphael em 29/10/2019.
 */
@Component
public class ThreadPoolBean {
    private static final ExecutorService POOL = Executors.newFixedThreadPool(150);

    public ExecutorService getPOOL() {
        return POOL;
    }
}
