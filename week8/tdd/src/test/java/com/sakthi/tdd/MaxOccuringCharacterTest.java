package com.sakthi.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.sakthi.tdd.MaxOccuringCharacter.InvalidCharacterException;
import com.sakthi.tdd.MaxOccuringCharacter.MaxOccurringCharacter;

public class MaxOccuringCharacterTest {
    @Test
    public void testFindMaxOccurringCharacterNegativeScenario() throws InvalidCharacterException {
        // Test with null input
        String input1 = null;
        assertThrows(NullPointerException.class, () -> MaxOccurringCharacter.findMaxOccurringCharacter(input1));

        // Test with an input containing non-alphabetical characters
        String input2 = "ram123";
        assertThrows(InvalidCharacterException.class, () -> MaxOccurringCharacter.findMaxOccurringCharacter(input2));

        // Test with an input containing a mixture of alphabetical and non-alphabetical
        // characters
        String input3 = "sri@venkatesh";
        assertThrows(InvalidCharacterException.class, () -> MaxOccurringCharacter.findMaxOccurringCharacter(input3));

        // Test with an input containing only non-alphabetical characters
        String input4 = "!@#&*()";
        assertThrows(InvalidCharacterException.class, () -> MaxOccurringCharacter.findMaxOccurringCharacter(input4));
    }

    public void testFindMaxOccurringCharacter() throws InvalidCharacterException {
        // Test with a valid input
        String input1 = "sridevi";
        char expected1 = 'i';
        assertEquals(expected1, MaxOccurringCharacter.findMaxOccurringCharacter(input1));

        // Test with an input containing multiple characters with the same frequency
        String input2 = "abbccc";
        char expected2 = 'c';
        assertEquals(expected2, MaxOccurringCharacter.findMaxOccurringCharacter(input2));

        // Test with an input containing uppercase characters
        String input3 = "Friends Forever";
        char expected3 = 'e';
        assertEquals(expected3, MaxOccurringCharacter.findMaxOccurringCharacter(input3));

        // Test with an input containing non-alphabetical characters
        String input4 = "freeind123";
        assertThrows(InvalidCharacterException.class, () -> MaxOccurringCharacter.findMaxOccurringCharacter(input4));
    }

    @Test
    public void testCountOccurrences() {
        // Test with an input containing no occurrences of the character
        String input1 = "hello";
        char character1 = 'z';
        int expected1 = 0;
        assertEquals(expected1, MaxOccurringCharacter.countOccurrences(input1, character1));

        // Test with an input containing a single occurrence of the character
        String input2 = "hello";
        char character2 = 'o';
        int expected2 = 1;
        assertEquals(expected2, MaxOccurringCharacter.countOccurrences(input2, character2));

        // Test with an input containing multiple occurrences of the character
        String input3 = "hello";
        char character3 = 'l';
        int expected3 = 2;
        assertEquals(expected3, MaxOccurringCharacter.countOccurrences(input3, character3));

        // Test with an empty string input
        String input4 = "";
        char character4 = 'a';
        int expected4 = 0;
        assertEquals(expected4, MaxOccurringCharacter.countOccurrences(input4, character4));

        // Test with null input
        String input5 = null;
        char character5 = 'a';
        assertThrows(NullPointerException.class, () -> MaxOccurringCharacter.countOccurrences(input5, character5));
    }

}
