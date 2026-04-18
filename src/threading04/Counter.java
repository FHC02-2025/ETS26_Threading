package threading04;

public class Counter implements Runnable {

    public static int Counter = 0;
    private static String key = "asdf";

    @Override
    public void run() {
        for (int i = 0; i< 1_000_000; i++) {
            increase();
        }
    }

    public void increase() {

        //warten
        synchronized (key) {
            Counter = Counter + 1;
        }
    }
}
