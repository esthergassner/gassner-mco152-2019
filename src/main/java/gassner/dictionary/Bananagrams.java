package gassner.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Bananagrams
{
    public boolean wordIsPresent(ArrayList<String> letters, String word)
    {
        boolean isPresent = false;
        ArrayList<String> tempLetterList = letters;

        StringBuilder wordPresent = new StringBuilder();
         for (String letter : word.split(""))
            {
                if (letters.contains(letter))
                {
                    wordPresent.append(letter);
                    tempLetterList.remove(letter);
                    if (wordPresent.toString().contentEquals(word))
                    {
                        isPresent = true;
                    }
                }
            }
         return isPresent;
    }

    public ArrayList<String> getWordsPresent(ArrayList<String> letters, DictionaryReader dictionary)
    {
        ArrayList<String> wordsPresent = new ArrayList<>();
        for (String word : dictionary.getList())
        {
            if (wordIsPresent(letters, word))
            {
                wordsPresent.add(word);
            }
        }
        return wordsPresent;
    }
}
