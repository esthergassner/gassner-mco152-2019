package gassner.dictionary;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class PalindromesTest
{
    @Test
    public void isPalindrome_true() throws FileNotFoundException
    {
        //given
        DictionaryReader dictionary = new DictionaryReader();
        Palindromes palindromes = new Palindromes();
        //when
        //then
        assertTrue(palindromes.isPalindrome("racecar"));
    }

    @Test
    public void isPalindrome_true_uppercase() throws FileNotFoundException
    {
        //given
        DictionaryReader dictionary = new DictionaryReader();
        Palindromes palindromes = new Palindromes();
        //when
        //then
        assertTrue(palindromes.isPalindrome("rAcecaR"));
    }

    @Test
    public void isPalindrome_false() throws FileNotFoundException
    {
        //given
        DictionaryReader dictionary = new DictionaryReader();
        Palindromes palindromes = new Palindromes();
        //when
        //then
        assertFalse(palindromes.isPalindrome("esther"));
    }

    @Test
    public void getPalindromes()
    {
        DictionaryReader dictionary = mock(DictionaryReader.class);
        Palindromes palindromes = new Palindromes();
        List<String> wordList = Arrays.asList("kaila", "esther", "dad", "hannah", "Helen", "Ayelet");
        doReturn(wordList).when(dictionary).getList();
        //given

        //when
        List<String> list = palindromes.getPalindromes(dictionary);
        //then
        assertEquals(2, list.size());
    }
}
