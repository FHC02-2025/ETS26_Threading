package threadingConsole;

import java.util.Date;

public class DateTimePrinterBackgroundWorker implements Runnable {

    private boolean shouldRun;


    public void setShouldRun(boolean shouldRun) {
        this.shouldRun = shouldRun;
    }

    public void worker() {

        shouldRun = true;
        while (shouldRun) {
            Date d = new Date();
            System.out.println(d);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) { // erklärung noch ausständing
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        worker();
    }
}
