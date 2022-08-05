
// Better best case
// We could get a better best case translating both strings in paralel, and returning false on the first mismatch
// The space complexity is the same, but we would create 2 maps at same time, instead of one then the other in the solution above
// Time: O(n) -> we iterate through the characters of both strings one time
// Space: O(n) -> 2*O(1) for the map (max length is number of ASCII characters) + two new strings with same length as originals

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Every character is translated
        // to the index of the first appearance
        // of this character in the string
        // We compare every character
        // and return false as soon as there is a mismatch
        // otherwise we return true
        
        // Isomorphic strings need to have the same size
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> firstIndexMap = new HashMap<Character, Integer>();
        Map<Character, Integer> secondIndexMap = new HashMap<Character, Integer>();
        
        StringBuilder builderOne = new StringBuilder();
        StringBuilder builderTwo = new StringBuilder();
        
        char currentFirstChar;
        char currentSecondChar;
        
        for (int i = 0; i < s.length(); i++) {
            currentFirstChar = s.charAt(i);
            currentSecondChar = t.charAt(i);
            
            if (!firstIndexMap.containsKey(currentFirstChar)) {
                firstIndexMap.put(currentFirstChar, i);
            }
            
            if (!secondIndexMap.containsKey(currentSecondChar)) {
                secondIndexMap.put(currentSecondChar, i);
            }
            
            
            // for every character translated, we return false if there is a mismatch
            if (firstIndexMap.get(currentFirstChar) != secondIndexMap.get(currentSecondChar)) {
                return false;
            }
        }
        return true;
        
    }

}
