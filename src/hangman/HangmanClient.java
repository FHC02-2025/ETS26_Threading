package hangman;

import java.io.*;
import java.net.Socket;

public class HangmanClient implements Runnable {
    private Game game;
    private Socket socket;
    private String name;

    public HangmanClient(Socket socket) {
        this.socket = socket;
        game = new Game();
    }

    @Override
    public void run() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ){

            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println("rec >> " + line);

                if (line.equals("EXIT")) {
                    bw.write("good bye");
                    bw.newLine();
                    bw.flush();
                    return;
                }
                else if (line.startsWith("NAME ")) {
                    String[] parts = line.split(" ");
                    name = parts[1];
                }
                else if (line.startsWith("TRY ")) {
                    String[] parts = line.split(" ");
                    String result = game.tryCharacter(parts[1].charAt(0));

                    bw.write("current status: " + result);
                    bw.newLine();

                    if (game.isFinished()) {
                        bw.write("Gratulation an " + name + "; Spiel erfolgreich beendet!");
                        bw.newLine();

                        bw.write("Neues Spiel gestartet, " + game.getLength() + " Zeichen zu suchen");
                        bw.newLine();
                    }
                }
                else {
                    bw.write("unkown command: " + line);
                    bw.newLine();
                }
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
