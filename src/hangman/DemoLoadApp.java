package hangman;

import java.util.ArrayList;
import java.util.Collections;

public class DemoLoadApp {
    public static void main(String[] args) throws DataFileException {


        DictionaryLoader dl = new DictionaryLoader();
        ArrayList<String> list = dl.load();

        Collections.sort(list, new StringLengthComparator());

        System.out.println("list = " + list);
        
        // Testing von Game
        
        Game hangman = new Game();
        System.out.println("hangman.tryCharacter('s') = " + hangman.tryCharacter('s'));
        System.out.println("hangman.tryCharacter('p') = " + hangman.tryCharacter('p'));
        System.out.println("hangman.tryCharacter('l') = " + hangman.tryCharacter('l'));
        System.out.println("hangman.tryCharacter('i') = " + hangman.tryCharacter('i'));

        System.out.println("hangman.isFinished() = " + hangman.isFinished());

        System.out.println("hangman.tryCharacter('S') = " + hangman.tryCharacter('S'));
        System.out.println("hangman.tryCharacter('e') = " + hangman.tryCharacter('e'));
        System.out.println("hangman.isFinished() = " + hangman.isFinished());
    }
}
