package gassner.dictionary;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BananagramsTest
{
    @Test
    public void wordIsPresent_true()
    {
        //given
        String word = "beds";
        Bananagrams bananagrams = new Bananagrams();
        List<String> lettersList = Arrays.asList("a", "d", "e", "b", "d", "s", "o", "i", "j", "u");
        ArrayList<String> letters = new ArrayList<>(lettersList);
        //when
        //then
        assertTrue(bananagrams.wordIsPresent(letters, word));
    }

    @Test
    public void wordIsPresent_false()
    {
        //given
        String word = "bedss";
        Bananagrams bananagrams = new Bananagrams();
        List<String> lettersList = Arrays.asList("a", "d", "e", "b", "d", "s", "o", "i", "j", "u");
        ArrayList<String> letters = new ArrayList<>(lettersList);
        //when
        //then
        assertFalse(bananagrams.wordIsPresent(letters, word));
    }

    @Test
    public void getWordsPresent()
    {
        //given
        DictionaryReader dictionary = mock(DictionaryReader.class);
        Bananagrams bananagrams = new Bananagrams();
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("kaila", "esther", "dad", "hannah", "Helen", "Ayelet"));
        List<String> lettersList = Arrays.asList("d", "a", "e", "b", "d", "s", "d", "i", "j", "u");
        ArrayList<String> letters = new ArrayList<>(lettersList);
        doReturn(wordList).when(dictionary).getList();
        //given

        //when
        ArrayList<String> list = bananagrams.getWordsPresent(letters, dictionary);
        //then
        assertEquals(1, list.size());
    }
}
