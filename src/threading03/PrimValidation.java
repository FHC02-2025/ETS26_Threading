package threading03;

public class PrimValidation implements Runnable {

    private final long number;
    private PrimValidationStatus statusPrimValidation;

    public PrimValidation(long number) {
        this.number = number;
        statusPrimValidation = PrimValidationStatus.NOT_STARTED;

    }

    public PrimValidationStatus isPrim() {
        return statusPrimValidation;
    }

    @Override
    public String toString() {
        return "PrimValidation{" +
                "number=" + number +
                '}';
    }

    public void validate() {
        // 1, 2, 3, 5, 7, 11

        statusPrimValidation = PrimValidationStatus.STARTED; // gestartet

        System.out.println(number + " => started");

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                statusPrimValidation = PrimValidationStatus.FINISHED_NOT_PRIM; // fertig, keine Prim
                break;
            }
        }

        if (statusPrimValidation == PrimValidationStatus.STARTED)
            statusPrimValidation = PrimValidationStatus.FINISHED_IS_A_PRIM; // fertig, eine Primzahl

        System.out.println(number + " => " + statusPrimValidation);

    }

    @Override
    public void run() {
        validate();
    }
}