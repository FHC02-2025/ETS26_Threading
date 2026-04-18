package hangman;

import java.util.ArrayList;

public class Game {

    private char[] currentWord;
    private char[] foundWord;
    private int counter;

    public int getLength() {
        return foundWord.length;
    }

    public Game() {
        loadWord();
        counter = 0;
    }

    public void loadWord() {
        DictionaryLoader dl = new DictionaryLoader();
        try {
            ArrayList<String> words = dl.load();

            currentWord = words.get(counter).toCharArray();
            counter++;
            foundWord = new char[currentWord.length];

            for (int i = 0; i < currentWord.length; i++) {
                foundWord[i] = '_';
            }

        } catch (DataFileException e) {
            throw new RuntimeException(e);
        }
    }

    public String tryCharacter(char c) {
        for (int i = 0; i < currentWord.length; i++) {
            if (currentWord[i] == c) {
                foundWord[i] = c;
            }
        }

        String result = "";
        for (int i = 0; i < foundWord.length; i++) {
            result = result + foundWord[i];
        }
        return result;
    }

    public boolean isFinished() {

        for (int i = 0; i < foundWord.length; i++) {
           if (foundWord[i] == '_') {
               return false;
           }
        }

        loadWord();
        return true;
    }
}
