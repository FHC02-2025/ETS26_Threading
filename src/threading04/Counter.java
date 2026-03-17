package threading04;

public class Counter implements Runnable {

    public static int Counter = 0;

    @Override
    public void run() {
        for (int i = 0; i< 1_000_000; i++) {
            increase();
        }
    }

    //synchronized (this)
    private void increase() {
        Counter = Counter + 1;
    }
}
