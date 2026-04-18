package hangman;

import java.util.ArrayList;
import java.util.Collections;

public class DemoLoadApp {
    public static void main(String[] args) throws DataFileException {


        DictionaryLoader dl = new DictionaryLoader();
        ArrayList<String> list = dl.load();

        Collections.sort(list, new StringLengthComparator());

        System.out.println("list = " + list);
        
    }
}
