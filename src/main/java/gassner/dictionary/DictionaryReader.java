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

        public DictionaryReader(ArrayList<String> words)
        {
            dictionary = words;
        }

        public int size()
        {
            return dictionary.size();
        }

        public boolean contains(String word)
        {
            return dictionary.contains(word.toUpperCase());
        }

        public boolean isPalindrome(String word)
        {
            String reversed = new StringBuilder(word).reverse().toString();
            return word.equalsIgnoreCase(reversed);
        }

        public List<String> getPalindromes()
        {
            ArrayList<String> palindromes = new ArrayList<>();
            for (String word : dictionary)
            {
                if(isPalindrome(word))
                {
                    palindromes.add(word);
                }
            }
            return palindromes;
        }
}
