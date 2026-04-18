package hangman;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(1234)){

            while (true) {
                System.out.println("waiting for client");
                Socket socket = serverSocket.accept();
                System.out.println("client connection");
                HangmanClient hc = new HangmanClient(socket);

                Thread th = new Thread(hc);
                th.start();
                System.out.println("client running in thread");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
