// 1- test all subarrays
//
// Time: O(n2) -> two nested loops (n-1) + (n-2) ... + 1 = ((n-1)(n))/2 = (n2 - n)/2;
// Space: O(1) -> no additional space besides 2 ints: sum and maxSum

// class Solution {
//     public int maxSubArray(int[] nums) {
//         // every subarray starts at a element with a particular index
//         // so to get all the subarrays
//         // we get all the subarrays starting at
//         // index 0, then all starting at index 1... until the last index
//         // to do this
//         // we iterate through the array
//         // starting from the 1st element, then 2st, then 3st element... until the last element
//         // checking every possible subarray that starts there
//         // we sum the elements for every subarray
//         // and return the biggest sum we found
        
//         int sum = 0;
//         int maxSum = Integer.MIN_VALUE;
        
//         for (int i = 0; i < nums.length; i++) {
//             sum = 0;
//             for (int j = i; j < nums.length; j++) {
//                 sum += nums[j];
//                 if (sum > maxSum) maxSum = sum;
//             }
//         }
//         return maxSum;
//     }
// }


// 2- excluding bad ones

// Time: O(n) -> iterate through the array one time
// Space:O(1) -> only space used is 2 ints: maxSum and sum

class Solution {
    public int maxSubArray(int[] nums) {
        // we can think of the subarray with the maxSum
        // as formed by parts added from left to right
        // a part with a negative sum shouldn't be in the final array
        // because it only lowers the total final sum
        // so to find the array with the maxSum
        // we narrow our search by discarting the arrays with parts that sum to negative
        
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            
            // if the current subpart contributes negatively or nothing, discart it
            if (sum <= 0) sum = 0;
            
            sum += nums[i];
            if (sum > maxSum) maxSum = sum;
        }
        return maxSum;
    }
}


// 3- It must be in one of 3 places (recursive)

// Time: O(n * log(n)) -> Divide the array by 2, log(n) times. In each of these times, we read the whole array (O(n)).
// Space: O(log(n)) -> Make log(n) recursive calls. Every recursive call has a O(1) space complexity because
// we use the same array in each call.


// class Solution {
 
//     private int[] numsArray;
    
//     public int maxSubArray(int[] nums) {
//         // The findBestSubArraySum method does all the work
//         // Here we just ask it to give us an answer
//         // for the whole array
//         numsArray = nums;
//         return findBestSubArraySum(0, nums.length - 1);
//     }
    
//     // recursive method that calls itself
//     private int findBestSubArraySum(int beginIndexInclusive, int endIndexInclusive) {
//         // The maxSum array must be either in the left half, right half, or center (one that includes the central element)
//         // part of the original array.
//         // We find the maxSum for these 3 possibilities, and return the bigger one of the 3.
        
//         // To find the maxSum in the center of an array, we sum the central element with the maxSum
//         // of the best arrays from the left and right neighborhoods of the central element
        
//         // To find the maxSum of the left and right halfs, we call this very function for the left and right halfs.

        
//         // if a empty array is passed, return 0
//         if (beginIndexInclusive > endIndexInclusive) {
//             return Integer.MIN_VALUE;
//         }
        
//         int middleIndex = Math.floorDiv(beginIndexInclusive + endIndexInclusive, 2);
        
//         int leftHalfMaxSum = findBestSubArraySum(beginIndexInclusive, middleIndex - 1);
//         int rightHalfMaxSum = findBestSubArraySum(middleIndex + 1, endIndexInclusive);
//         int centerMaxSum = findBestCenterSubArraySum(middleIndex, endIndexInclusive);
        
//         return Math.max(Math.max(leftHalfMaxSum, rightHalfMaxSum), centerMaxSum);
//     }
    
    
//     private int findBestCenterSubArraySum(int middleIndex, int endIndexInclusive) {
//         // Returns the sum of the center element with the
//         //  maxSum of the best right neighbor array to it's right, and to it's left
        
//         //Left of center
//         int maxSumLeft = 0;
//         int tempSum = 0;
//         for (int i = middleIndex - 1; i >= 0; i--) {
//             tempSum += numsArray[i];
//             maxSumLeft = Math.max(maxSumLeft, tempSum);
//         }
        
//         // Right of center
//         int maxSumRight = 0;
//         tempSum = 0;
//         for (int i = middleIndex + 1; i < numsArray.length; i++) {
//             tempSum += numsArray[i];
//             maxSumRight = Math.max(maxSumRight, tempSum);
//         }
        
//         return numsArray[middleIndex] + maxSumRight + maxSumLeft;
        
//     } 
// }