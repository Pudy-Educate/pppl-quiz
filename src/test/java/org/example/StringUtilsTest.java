package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    private static StringUtils utils;
    @BeforeAll
    static void initCLass(){
         utils = new StringUtils();
    }

    @Test
    void testReverseString() {
        Assertions.assertEquals("kasur",utils.reverseString("rusak"));
    }

    @Test
    void testReverseStringWithChar() {
        Assertions.assertEquals("1kasur",utils.reverseString("rusak1"));
    }
    @Test
    void testReverseStringNull() {
        Assertions.assertNull(utils.reverseString(null));
    }

    @Test
    void testIsPalindrome() {
        Assertions.assertTrue(utils.isPalindrome("civic"));
    }
    @Test
    void testIsNotPalindrome() {
        Assertions.assertFalse(utils.isPalindrome("Xivic"));
    }
    @Test
    void testIsPalindromeWithCapitalLetter() {
        Assertions.assertTrue(utils.isPalindrome("Civic"));
    }
    @Test
    void testIsPalindromeNull() {
        Assertions.assertFalse(utils.isPalindrome(null));
    }

    @Test
    void testCountVowels() {
        Assertions.assertEquals(2,utils.countVowels("civic"));
    }

    @Test
    void testCountVowelsCapital() {
        Assertions.assertEquals(2,utils.countVowels("civIc"));
    }
    @Test
    void testCountVowelsNull() {
        Assertions.assertEquals(0,utils.countVowels(null));
    }

}