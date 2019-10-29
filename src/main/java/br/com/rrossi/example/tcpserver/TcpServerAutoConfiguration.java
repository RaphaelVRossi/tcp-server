package br.com.rrossi.example.tcpserver;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Criado por Raphael em 01/10/2019.
 */
@Configuration
public class TcpServerAutoConfiguration {

    @Bean
    TcpServerAutoStarterApplicationListener tcpServerAutoStarterApplicationListener() {
        return new TcpServerAutoStarterApplicationListener();
    }

    @Bean
    BeanPostProcessor tcpControllerBeanPostProcessor() {
        return new TcpControllerBeanPostProcessor();
    }

    @Bean
    Server server() {
        return new TcpServer();
    }

    @Bean
    ThreadPoolBean threadPoolBean() {
        return new ThreadPoolBean();
    }
}
