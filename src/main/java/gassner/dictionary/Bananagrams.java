package gassner.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Bananagrams
{
    private DictionaryReader dictionary;

    public Bananagrams(DictionaryReader dictionary)
    {
        this.dictionary = dictionary;
    }

    /**
     *
     * @param letters pool of letters
     * @param word word being checked
     * @return a boolean value telling whether the word is present
     */
    public boolean wordIsPresent(List<String> letters, String word)
    {
        ArrayList<String> tempLetterList = new ArrayList<>();
        for (String str : letters) {
            tempLetterList.add(str);
        }

        StringBuilder wordPresent = new StringBuilder();
         for (String letter : word.split(""))
            {
                if (tempLetterList.contains(letter))
                {
                    wordPresent.append(letter);
                    tempLetterList.remove(letter);
                    if (wordPresent.toString().contentEquals(word))
                    {
                        return true;
                    }
                }
            }
         return false;
    }

    /**
     *
     * @param letters pool of letters
     * @return a list of words in the DictionaryReader that are a subset of these letters
     */
    public ArrayList<String> getWordsPresent(List<String> letters)
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
