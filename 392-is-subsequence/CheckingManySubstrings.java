// name: CheckingManySubstrings.java

// for the worst case
// Time: O(|s|*|t|) -> |s| hashtable lookups * linear search worst case is every index of t
// Space: O(|t|) -> the hashmap
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    private HashMap<Character, ArrayList<Integer>> map = null;
    
    public boolean isSubsequence(String s, String t) {
        // When checking many substrings,
        // we can end up needing to search the whole t
        // for every new string s
        // Using some extra space (HashMap)
        // we could make the searches faster O(|t|) -> O(1)
        // thus making our algorithm faster
        
        // We will create a HashMap
        // of each char of t, and an array of it's index locations in t
        // Then we will iterate through the chars of s
        // looking for matches in t using the hashmap
        // and return true if we can match every char of s in t
        // in the correct order
        
        // Space cost: |t|
        // create the index map
        map = new HashMap<Character, ArrayList<Integer>>();
        
        char currentChar;
        
        // Time cost: |t|
        // populate the index map with a index list for every character in t
        ArrayList<Integer> currentCharIndexList;
        for (int i = 0; i < t.length(); i++) {
            currentChar = t.charAt(i);
            
            if (map.containsKey(currentChar)) {
                map.get(currentChar).add(i);
            } else {
                currentCharIndexList = new ArrayList<Integer>();
                currentCharIndexList.add(i);
                map.put(currentChar, currentCharIndexList);
            }
        }
        
        int tPointer = -1;
        
        // Time cost: |s| * |t|
        // Check every character in s for a match in t
        for (int i = 0; i < s.length(); i++) {
            tPointer = getPointerNextPosition(s.charAt(i), tPointer);
            // the current character of s is not in t
            // at a valid index position
            if (tPointer == -1) return false;
            
        }
        return true;
    }
    
    // Time cost: |t|
    // Check a character received for a match in t
    private int getPointerNextPosition(char c, int tPointer) {
        // auxiliary method
        // Advances the tPointer to the correct position
        // if the given s character is found in t
        // or return -1 if it's not
        
        if (!map.containsKey(c)) return -1;
        
        // search for the first index bigger than tPointer and return it if found
        // this will be the next tPointer position
        for (int index: map.get(c)) {
            if (index > tPointer) {
                return index;
            }
        }
        // no valid index was found
        return -1;
    }
    
}