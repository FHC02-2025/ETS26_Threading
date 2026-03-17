package threading03;

public class PrimValidation implements Runnable {

    private final long number;


    public PrimValidation(long number) {
        this.number = number;

    }

    @Override
    public String toString() {
        return "PrimValidation{" +
                "number=" + number+
                '}';
    }

    private void validate(){

        boolean isPrim = true;

        for (long i = 2; i < number; i++){
            if (number % i == 0) {
                isPrim = false;
                break;
            }
        }



        System.out.println("done: " + number + " is a Prim: " + isPrim);
    }

    @Override
    public void run() {
        validate();
    }
}
