// 1- Using external HashSet
//
// Time: O(n) -> n reads of array elements + n reads of HashSet elements + n writes to HashSet = 3n
// Space: O(n) -> creates one HashSet with n entries

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Pass through the array
        // check if is already in the HashSet
        // if it is, it was seen before, return true
        // if it's not, add it
        // if no elements were seen before, return false
        
        HashSet<Integer> seenSet = new HashSet<Integer>();
        
        for (Integer num: nums) {
            if (seenSet.contains(num)) return true;
            seenSet.add(num);
        }
        return false;
        
    }
}


// 2- Using a nested loop and no external memory
// 
// Time: O(n2) -> (n-1) + (n - 2) ... + 1 = (n-1)(n)/2 = (n2 - n) / 2
// Space: O(1)

// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         // For each element except the last one
//         // compare it to all other elements
//         // that come next to it
//         // if a duplicate is found, return true
//         // if no duplicate is found
//         // at the end of the loops, return false
        
//         for (int i = 0; i < nums.length - 1; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (nums[i] == nums[j]) return true;
//             }
//         }
//         return false;
//     }
// }



// 3 - Sorting the array first and comparing each element with it's neighbor
//
// Time: O(n * log(n)) -> (n * log(n)) [sorting] + n [one pass through the array] 
// Space: O(1) -> no external data structure used

// import java.util.Arrays;
// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         // Sort the array in place
//         // Loop through the elements one time (except the last one)
//         // comparing every element with it's neighbor
//         // if a match is found, return true
//         // if no match is found, return false
        
//         Arrays.sort(nums);
        
//         for (int i = 0; i < nums.length - 1; i++) {
//             if (nums[i] == nums[i + 1]) return true;
//         }
//         return false;
//     }
// }