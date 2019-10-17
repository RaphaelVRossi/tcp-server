package br.com.rrossi.example.tcpserver;

/**
 * Criado por Raphael em 01/10/2019.
 */
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface TcpController {
}