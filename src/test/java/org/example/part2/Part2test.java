package org.example.part2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Part2test {

    // Test for Problem 1: twoSum
    @Test
    void testTwoSum() {
        assertArrayEquals(new int[]{0, 1}, Problems.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, Problems.twoSum(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{}, Problems.twoSum(new int[]{3, 3}, 7));
    }

    // Test for Problem 2: isPalindrome
    @Test
    void testIsPalindrome() {
        assertTrue(Problems.isPalindrome(121));
        assertFalse(Problems.isPalindrome(-121));
        assertFalse(Problems.isPalindrome(10));
    }

    // Test for Problem 3: longestCommonPrefix
    @Test
    void testLongestCommonPrefix() {
        assertEquals("fl", Problems.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", Problems.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        assertEquals("a", Problems.longestCommonPrefix(new String[]{"abc","ab","a"}));
    }

    // Test for Problem 4: romanToInt
    @Test
    void testRomanToInt() {
        assertEquals(3, Problems.romanToInt("III"));
        assertEquals(58, Problems.romanToInt("LVIII"));
        assertEquals(1994, Problems.romanToInt("MCMXCIV"));
    }

    // Test for Problem 5: isValid
    @Test
    void testIsValid() {
        assertTrue(Problems.isValid("()"));
        assertTrue(Problems.isValid("()[]{}"));
        assertFalse(Problems.isValid("(]"));
        assertFalse(Problems.isValid("([)]"));
        assertTrue(Problems.isValid("{[]}"));
    }

    // Test for Problem 6: mergeTwoLists
    @Test
    void testMergeTwoLists() {
        Problems.ListNode l1 = new Problems.ListNode(1, new Problems.ListNode(2, new Problems.ListNode(4)));
        Problems.ListNode l2 = new Problems.ListNode(1, new Problems.ListNode(3, new Problems.ListNode(4)));
        Problems.ListNode merged = Problems.mergeTwoLists(l1, l2);
        assertEquals(1, merged.val);
        assertEquals(1, merged.next.val);
        assertEquals(2, merged.next.next.val);
        assertEquals(3, merged.next.next.next.val);
        assertEquals(4, merged.next.next.next.next.val);
        assertEquals(4, merged.next.next.next.next.next.val);
        assertNull(merged.next.next.next.next.next.next);
    }

    // Test for Problem 7: plusOne
    @Test
    void testPlusOne() {
        assertArrayEquals(new int[]{1, 2, 4}, Problems.plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{4, 3, 2, 2}, Problems.plusOne(new int[]{4, 3, 2, 1}));
        assertArrayEquals(new int[]{1, 0, 0, 0}, Problems.plusOne(new int[]{9, 9, 9}));
    }
}
