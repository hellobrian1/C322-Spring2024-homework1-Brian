package org.example.part2;

import java.util.Stack;

public class Problems {


    // problem 1
    static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    // problem 2
    static boolean isPalindrome(int x) {
        if (x < 0) {

            return false;
        }
        int reversed = 0;
        int original = x;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return original == reversed;
    }

    // problem 3
    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < n; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); // remove the last character
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    // problem 4
    static int romanToInt(String roman) {
        int n = roman.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int s1 = value(roman.charAt(i));
            if (i + 1 < n) {
                int s2 = value(roman.charAt(i + 1));
                if (s1 >= s2) {
                    result += s1;
                } else {
                    result += s2 - s1;
                    i++;
                }
            } else {
                result += s1;
            }
        }
        return result;
    }

    private static int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') { // open brackets
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static Problems.ListNode mergeTwoLists(Problems.ListNode list1, Problems.ListNode list2) {
        if(list1!=null && list2!=null)
        {
            if(list1.val < list2.val)
            {
                list1.next =  mergeTwoLists(list1.next,list2);
                return list1;
            }
            else
            {
                list2.next = mergeTwoLists(list1,list2.next);
                return list2;
            }
        }
        if(list1 == null)
            return list2;
        return list1;
    }


    public static class ListNode {
        int val;
        Problems.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, Problems.ListNode next) { this.val = val; this.next = next; }

    }

    static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) { // if the digit is not 9, then we can just increment it by 1
                digits[i]++;
                return digits;
            } else { // if the digit is 9, then we need to set it to 0 and continue the loop
                digits[i] = 0;
            }
        }
        // if we reach here, then all the digits are 9
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

}
