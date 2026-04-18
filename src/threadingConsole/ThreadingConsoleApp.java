package threadingConsole;

import java.io.IOException;

public class ThreadingConsoleApp {

    public static void main(String[] args) {
        DateTimePrinterBackgroundWorker backgroundWorker = new DateTimePrinterBackgroundWorker();

        Thread th = new Thread(backgroundWorker);
        th.start();

        try {
            // Warten auf ein Zeichen
            System.out.println("Warte auf Eingabe");
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Zeichen eingelesen

        System.out.println("Eingabe erfolgt, Abbruch, Warten auf Ende....");
        try {
            //th.stop();
            backgroundWorker.setShouldRun(false);
            th.join();
            System.out.println("Thread gestoppt");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
