package com.sakthi.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.sakthi.tdd.LongestSubstring.LongestSubstring;

public class LongestSubstringTest {

    @Test
    public void testFindLongestSubstring() {
        String str1 = "sakthikumar";
        String expected1 = "thikumar";
        assertEquals(expected1, LongestSubstring.findLongestSubstring(str1));

        String str3 = "";
        String expected3 = "";
        assertEquals(expected3, LongestSubstring.findLongestSubstring(str3));

        String str4 = "aaaaaaa";
        String expected4 = "a";
        assertEquals(expected4, LongestSubstring.findLongestSubstring(str4));

        String str5 = "abcdefg";
        String expected5 = "abcdefg";
        assertEquals(expected5, LongestSubstring.findLongestSubstring(str5));

    } 
 
    @Test
    public void testFindLongestSubstring_NullString() {
        String str = null;
        
        assertThrows(IllegalArgumentException.class, () -> {LongestSubstring.findLongestSubstring(str);});
    }

    @Test
    public void testFindLongestSubstring_EmptyString() {
        String str = "";
        String expected = "";
        assertEquals(expected, LongestSubstring.findLongestSubstring(str));
    }
}