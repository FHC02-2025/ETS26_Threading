package threading02;

public class ConsolePrinterDemoApp {

    public static void main(String[] args) throws InterruptedException {


        ConsolePrinter cpA = new ConsolePrinter("A");
        ConsolePrinter cpB = new ConsolePrinter("B");

        Thread thCpA = new Thread(cpA);
        Thread thCpB = new Thread(cpB);

        thCpA.start();
        thCpB.start();

        thCpA.join();
        thCpB.join();


    }
}
