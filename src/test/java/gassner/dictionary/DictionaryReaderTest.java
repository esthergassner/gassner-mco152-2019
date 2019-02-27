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
        assertTrue(dictionary.contains("WONDERFUL"));
    }

    @Test
    public void contains_false() throws FileNotFoundException {
        //given
        DictionaryReader dictionary = new DictionaryReader();

        //when
        //then
        assertFalse(dictionary.contains("gassner"));
    }

    @Test
    public void contains_true_uppercase() throws FileNotFoundException {
        //given
        DictionaryReader dictionary = new DictionaryReader();

        //when
        //then
        assertTrue(dictionary.contains("WoNdErFuL"));
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