package hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DictionaryLoader {

    public ArrayList<String> load() throws DataFileException {

        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(".\\data\\dictionary.txt"))) {

            String line = "";
            while ((line = br.readLine()) != null){
                list.add(line);
            }

        } catch (FileNotFoundException e) {
            throw new DataFileException(e);
        } catch (IOException e) {
            throw new DataFileException(e);
        }
        return list;
    }
}
