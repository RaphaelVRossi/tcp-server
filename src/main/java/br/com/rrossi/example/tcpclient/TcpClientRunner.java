package br.com.rrossi.example.tcpclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

/**
 * Criado por Raphael em 29/10/2019.
 */
@Component
@Slf4j
public class TcpClientRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        try (
                Socket kkSocket = new Socket(args[0], Integer.parseInt(args[1]));
                BufferedInputStream input = new BufferedInputStream(kkSocket.getInputStream());

                BufferedOutputStream outPutStream = new BufferedOutputStream(kkSocket.getOutputStream())
        ) {

//            String message = "0200A01A00008800000200000000100000008900021641580824082404010400000012302911200121181150018743457754               00000005999240820181161506201784880000000599900899999959999984265726043429048115";
            String message = "9100A01A00008800000200000000100000008900021641580824082404010400000012302911200121181150018743457754               00000005999240820181161506201784880000000599900899999959999984265726043429048115";

            log.info("Sending message to socket [{}]", message);

            sendMessage(outPutStream, message);

            log.info("Waiting response from socket");

            String response = readMessage(input);

            log.info("Received response from socket [{}]", response);

        } catch (Exception e) {
            log.error("Error", e);
        }
    }

    private static String readMessage(BufferedInputStream input) throws IOException {
        byte[] sizeBytes = new byte[2];
        int n = input.read(sizeBytes);
        if (n < 0) {
            return null;
        }
        if (n < 2) {
            log.info("Esperados 2, lidos " + n + " bytes!");
            return null;
        }
        int size = Byte.toUnsignedInt(sizeBytes[0]) * 256 + Byte.toUnsignedInt(sizeBytes[1]);
        byte[] messageBytes = new byte[size];
        n = input.read(messageBytes);
        if (n < size) {
            log.info("Esperados " + size + ", lidos " + n + " bytes!");
            return null;
        }
        System.out.println(Arrays.toString(sizeBytes) + " " + size + " bytes: " + Arrays.toString(messageBytes));
        String message = new String(messageBytes);
        log.info("Mensagem recebida: " + message);
        return message;
    }

    private static void sendMessage(BufferedOutputStream output, String message) throws IOException {
        log.info("Enviando mensagem: " + message);
        byte[] sizeBytes = new byte[2];
        byte[] messageBytes = message.getBytes();
        sizeBytes[0] = (byte) (messageBytes.length / 256);
        sizeBytes[1] = (byte) (messageBytes.length % 256);
        log.info("tamanho: " + messageBytes.length + " " + Arrays.toString(messageBytes));
        log.info(Arrays.toString(sizeBytes) + " " + messageBytes.length + " bytes: " + Arrays.toString(messageBytes));
        output.write(sizeBytes);
        output.write(messageBytes);
        output.flush();
    }
}


