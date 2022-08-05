// 2- Universal language
//
// Time: O(n) -> we iterate through the characters of both strings one time
// Space: O(n) -> O(1) for the map (max length is number of ASCII characters) + two new strings with same length as originals
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // We create 2 new strings
        // coded in the 'first index language'
        // It works like this:
        // Every character is translated
        // to the index of the first appearance
        // of this character in the string
        // In the end we compare the translated strings
        // If they are equal, they are isomorphic
        
        // Isomorphic strings need to have the same size
        if (s.length() != t.length()) return false;
        
        return translateString(s).equals(translateString(t));
        
        
    }
    
    private String translateString(String s) {
    
        Map<Character, Integer> firstIndexMap = new HashMap<Character, Integer>();
        
        StringBuilder builder = new StringBuilder();
        
        char currentChar;
        
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (!firstIndexMap.containsKey(currentChar)) {
                firstIndexMap.put(currentChar, i);
            }
            // adding a space is needed to prevent double digit numbers being confused with single digit numbers
            builder.append(firstIndexMap.get(currentChar) + " ");
        }
        return builder.toString();
    }
}
