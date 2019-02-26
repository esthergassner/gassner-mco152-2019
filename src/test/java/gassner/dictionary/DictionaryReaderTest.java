package gassner.dictionary;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DictionaryReaderTest {

    @Test
    public void contains_true() throws FileNotFoundException {
        //given
        DictionaryReader dictionary = new DictionaryReader();

        //when
        //then
        assertTrue(dictionary.checkIfPresent("WONDERFUL"));
    }

    @Test
    public void contains_false() throws FileNotFoundException {
        //given
        DictionaryReader dictionary = new DictionaryReader();

        //when
        //then
        assertFalse(dictionary.checkIfPresent("gassner"));
    }

    @Test
    public void contains_true_uppercase() throws FileNotFoundException {
        //given
        DictionaryReader dictionary = new DictionaryReader();

        //when
        //then
        assertTrue(dictionary.checkIfPresent("WoNdErFuL"));
    }

    @Test
    public void isPalindrome_true() throws FileNotFoundException
    {
        //given
        DictionaryReader dictionary = new DictionaryReader();
        //when
        //then
        assertTrue(dictionary.isPalindrome("racecar"));
    }

    @Test
    public void isPalindrome_true_uppercase() throws FileNotFoundException
    {
        //given
        DictionaryReader dictionary = new DictionaryReader();
        //when
        //then
        assertTrue(dictionary.isPalindrome("rAcecaR"));
    }

    @Test
    public void isPalindrome_false() throws FileNotFoundException
    {
        //given
        DictionaryReader dictionary = new DictionaryReader();
        //when
        //then
        assertFalse(dictionary.isPalindrome("esther"));
    }

    @Test
    public void getPalindromes()
    {
        //given
        ArrayList<String> wordList = new ArrayList<String>();
        wordList.add("racecar");
        wordList.add("esther");
        wordList.add("KayAk");
        DictionaryReader dictionary = new DictionaryReader(wordList);
        ArrayList<String> expectedPalindromes = new ArrayList<String>();
        expectedPalindromes.add("racecar");
        expectedPalindromes.add("KayAk");
        //when
        //then
        assertEquals(expectedPalindromes, dictionary.getPalindromes());
    }

    @Test
    public void size() throws FileNotFoundException
    {
        //given
        DictionaryReader dictionary = new DictionaryReader();
        //when
        //then
        assertEquals(167964, dictionary.size());
    }

}