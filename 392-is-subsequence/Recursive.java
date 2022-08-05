// name: Recursive.java

// for the worst case
// Time: O(|t|) -> we will have to search the full length of t
// Space: O(|t|) -> we will have to do one recursive call for every char of t

class Solution {
    public boolean isSubsequence(String s, String t) {
        // We compare the first character of 's' and 't'
        // If they are equal, the answer to the original question
        // comes down to isSubsequence(s[1:], t[1:])
        // because we know that considering only the first character,
        // s is a substring of t
        // So what we have left to do
        // is to check if the rest of s
        // is a subsequence of the rest of t
        // If the first characters are different,
        // the answer to the original questions comes down to
        // isSubsequence(s, t[1:])
        // because we are still looking for the first character of s in t
        // but we can discart the first character of t as we know
        // it is already not the first character of s
        
        // We use a recursive approach
        // The base case being when s is over (empty)
        // meaning we found every char of s in t (return true)
        // or that s was empty to begin with;
        // The other base case is when s is bigger than t
        // meaning we can give up the search
        // because t will never have enough
        // characters for s to be a substring of it
        
        // a empty substring is always a substring
        if (s.length() == 0) return true;
        
        // a substring can't be bigger than it's target string
        if (s.length() > t.length()) return false;
    
        
        // it's nice that java 'substring' method doens't throw an error
        // when trying to get a substring starting from an index
        // bigger then the size of a string
        // instead it returns an empty string
        
        // if the first chars are different
        // continue search the same character of s
        // in the rest of t
        if (s.charAt(0) != t.charAt(0)) {
            return isSubsequence(s, t.substring(1));
        }
        // if the first chars are equals
        // continue searching the next character of s
        // starting from the next character of t
        else {
            return isSubsequence(s.substring(1), t.substring(1));
        }
        
    }
}