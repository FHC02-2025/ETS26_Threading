package threading02;

public class ConsolePrinter  {


    private String identifier;

    public ConsolePrinter(String identifier) {
        this.identifier = identifier;
    }

    public void logic() {
        for (int i = 0; i < 1_000_000; i++) {
            System.out.println(i + ": [identifier: " + identifier + ']');


        }
    }
}
