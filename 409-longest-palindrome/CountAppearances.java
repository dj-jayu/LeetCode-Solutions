// name: CountAppearances.java

// Time: O(n) -> iterate one time through the String of length 'n'
// Space: O(1) -> the space will only grow to a max of the total number of upper/lower case english letters

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {
        // We will iterate one time through the string
        // saving the the number of times each letter appears
        // we define total as the length of the max palindrome possible
        // and adds 'number' for every character that appears a even 'number' of times
        // and adds 'number - 1' for every character that appears an odd number of times
        // then we add +1 if there is any character that appears an odd number of times
        // (because this will be the center character)
        
        Map<Character, Integer> charMap = new HashMap<>();
        char currentChar = 'k';
        
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            
            if (!charMap.containsKey(currentChar)) {
                charMap.put(currentChar, 1);
            } else {
                charMap.replace(currentChar, charMap.get(currentChar) + 1);
            }
        }
        
        int oddChars = 0;
        int total = 0;
        for (Integer value: charMap.values()) {
            if (value % 2 == 0) total += value;
            else {
                total += value - 1;
                oddChars++;
            }
        }
        total = oddChars > 0 ? total + 1 : total;
        return total;
    }
}