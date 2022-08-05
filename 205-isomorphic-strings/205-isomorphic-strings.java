// 1- One to one or false
//
// Time: O(n) -> 2*n, iterate one time through both strings
// Space: O(1) -> The maximum size of our 2 Maps would be the number of possible ASCII characters
// since we will never repeat a pair

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Iterate through the strings
        // making a map of the characters
        // that have the same index
        // if a character maps to two different characters
        // in either way
        // return false
        // else return true
        
        // if the sizes are different, they can't be isomorphic
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> LRmap = new HashMap<Character, Character>();
        Map<Character, Character> RLmap = new HashMap<Character, Character>();
        
        char sCurrentCharacter;
        char tCurrentCharacter;
        
        for (int i = 0; i < s.length(); i++) {
            
            sCurrentCharacter = s.charAt(i);
            tCurrentCharacter = t.charAt(i);
            
            // if the elements of the pair were seen before with another element, return false
            if (LRmap.containsKey(sCurrentCharacter) && LRmap.get(sCurrentCharacter) != tCurrentCharacter) {
                return false;
            } 
            
            if (RLmap.containsKey(tCurrentCharacter) && RLmap.get(tCurrentCharacter) != sCurrentCharacter) {
                return false;
            }
            
            // if this pair was not yet seen, add it to the Map
            if (!LRmap.containsKey(sCurrentCharacter) && !RLmap.containsKey(tCurrentCharacter)) {
                LRmap.put(sCurrentCharacter, tCurrentCharacter);
                RLmap.put(tCurrentCharacter, sCurrentCharacter);
            }
        }
        
        // if we get to here, it means all pairs are unique
        return true;
    }
}

