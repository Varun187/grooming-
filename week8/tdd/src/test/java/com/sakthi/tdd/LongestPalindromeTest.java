package com.sakthi.tdd;


import org.springframework.boot.test.context.SpringBootTest;

import com.sakthi.tdd.LongestPalindrome.LongestPalindrome;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class LongestPalindromeTest {

    @Test
    public void testLongestPalindrome_NullString() {
        String str = null;
        int expectedLength = 0; 
        int actualLength = LongestPalindrome.longestPalindrome(str);
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void testLongestPalindrome_NoPalindromeWithSpaces() {
        String str = "Trying to use junit";
        int expectedLength = 0;
        int actualLength = LongestPalindrome.longestPalindrome(str);
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void testLongestPalindrome() {
        String str = "sealaemydnfkfa";
        int expectedLength = 5;
        int actualLength = LongestPalindrome.longestPalindrome(str);
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void testLongestPalindrome_EmptyString() {
        String str = "";
        int expectedLength = 0; 
        int actualLength = LongestPalindrome.longestPalindrome(str);
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void testLongestPalindrome_SingleCharacter() {
        String str = "a";
        int expectedLength = 1;
        int actualLength = LongestPalindrome.longestPalindrome(str);
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void testLongestPalindrome_NoPalindrome() {
        String str = "abcdef";
        int expectedLength = 0;
        int actualLength = LongestPalindrome.longestPalindrome(str);
        assertEquals(expectedLength, actualLength);
    }

}
