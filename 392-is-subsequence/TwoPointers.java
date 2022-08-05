// name: TwoPointers.java

// Time: O(|t|) -> In the worst case we do one comparison for each character of the target string
// Space: O(1) -> We use the same number of auxiliary variables (2 ints) independently of the input size

class Solution {
    public boolean isSubsequence(String s, String t) {
        // For each character of the substring 's'
        // we will try to find the same character in 't'
        // going from left to right in 't' and don't comming back
        // In the end if we went through all the characters in 's'
        // it means we found all the characters
        // and that 's' is a substring of 't'.
        
        int sPointer = 0;
        int tPointer = 0;
        
        // a empty string is always a substring
        if (s.length() == 0) return true;
        
        // a substring can't be bigger than it's parent string
        if (s.length() > t.length()) return false;
        
        
        while(sPointer < s.length() && tPointer < t.length()) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
                tPointer++;
            } else {
                tPointer++;
            }
        }
        if (sPointer == s.length()) return true;
        return false;
    }
}