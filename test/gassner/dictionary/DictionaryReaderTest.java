package gassner.dictionary;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

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

}