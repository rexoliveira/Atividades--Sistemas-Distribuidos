package servidorcliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServidorWeb {

    public static void main(String[] args) throws IOException {

        int porta = 8081;

        ServerSocket serverSocket = new ServerSocket(porta);
        System.out.println("Servidor iniciado na porta: " + porta);

        while (true) {
            Socket clienteSocket = serverSocket.accept();
            System.err.println("Cliente conectado");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

            String texto;

            while ((texto = entrada.readLine()) != null) {
                System.out.println(texto);
                if (texto.isEmpty()) {
                    break;
                }
            }
            OutputStream clienteSaida = clienteSocket.getOutputStream();
            clienteSaida.write("HTTP/1.1 200 OK\r\n".getBytes());
            clienteSaida.write("\r\n".getBytes());
            clienteSaida.write("<h1>Seja bem vindo!Teste</h1>".getBytes());
            clienteSaida.write("\r\n\r\n".getBytes());
            clienteSaida.flush();
            System.err.println("Cliente conectado, saiu!");
            entrada.close();
            clienteSaida.close();
        }
    }
}
