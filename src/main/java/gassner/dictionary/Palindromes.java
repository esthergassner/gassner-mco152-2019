package gassner.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Palindromes
{
    public boolean isPalindrome(String word)
    {
        return new StringBuilder(word)
                .reverse()
                .toString()
                .equalsIgnoreCase(word);
    }

    public ArrayList<String> getPalindromes(DictionaryReader dictionary)
    {
        ArrayList<String> palindromes = new ArrayList<>();
        for (String word : dictionary.getList())
        {
            if(isPalindrome(word))
            {
                palindromes.add(word);
            }
        }
        return palindromes;
    }
}
