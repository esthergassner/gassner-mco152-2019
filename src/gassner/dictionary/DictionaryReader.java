package gassner.dictionary;

import java.io.*;
import java.util.*;

public class DictionaryReader {

        private ArrayList<String> dictionary = new ArrayList<>();

        public DictionaryReader() throws FileNotFoundException
        {
                Scanner scanner = new Scanner(new File("dictionary.txt"));
                while(scanner.hasNext())
                {
                    dictionary.add(scanner.next());
                    scanner.nextLine();
                }
                scanner.close();
        }

        public int size()
        {
            return dictionary.size();
        }

        public boolean checkIfPresent(String word)
        {
            return dictionary.contains(word.toUpperCase());
        }

        public boolean isPalindrome(String word)
        {
            //todo
            return false;
        }

        public List<String> getPalindromes()
        {
            return null;
        }
}
