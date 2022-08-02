// 1- Calculate left/right and right/left cumulative sum, saving the results in different arrays
// and returns the first equal result between the two

// Time: O(n) (3 * n, one for the L/R cumsum, one for R/L cumsum, one for finding the match)
// Space: O(n) (2 * n, we create 2 extra arrays, one for L/R cumsum, one for R/L cumsum)
// 
// class Solution {
    
//     public int pivotIndex(int[] nums) {
//         // get the cummulative sum of the array
//         // from left to right
//         // and right to left
//         // compare the results
//         // returns the first match (going from left to right)        
        
//         int[] leftCumulativeSum = sumCumulativeLR(nums);
//         int[] rightCumulativeSum = sumCumulativeRL(nums);
        
//         for (int i = 0; i < nums.length; i++) {
//             if (leftCumulativeSum[i] == rightCumulativeSum[i]) {
//                 return i;
//             }
//         }
//         return -1;
        
        
        
        
//     }
    
    
//     // returns a cummulative sum array
//     private int[] sumCumulativeLR(int[] nums) {
//         // go through the array
//         // summing the current element
//         // with the sum of the elements before
//         // saving the result in the current index
//         // and returning the array at the end
        
//         int[] returnArray = new int[nums.length];
//         int sumBefore = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (i != 0) {
//                 sumBefore = returnArray[i - 1];
//             }
//             returnArray[i] = nums[i] + sumBefore;
//         }

//         return returnArray;
//     }
    
//     // returns a cummulative sum from right to left
//     private int[] sumCumulativeRL(int[] nums) {
//         // go through the array from right to left
//         // summing the current element with the
//         // sum of the elements to the right
//         // saving the result to the current index
//         // and returning the array at the end
//         int[] returnArray = new int[nums.length];
//         int sumOfRight = 0;
        
//         for (int i = nums.length - 1; i >= 0; i--) {
//             if (i != nums.length - 1) sumOfRight = returnArray[i + 1];
//             returnArray[i] = nums[i] + sumOfRight;
//         }
//         return returnArray;
//     }
// }




// 2- Compare left cumsum right cumsum (equals totalSum - left cumsum - current element)
//
// Time: O(n) - we go through the array one time
// Space: O(1) - no additional space needed

class Solution {
    public int pivotIndex(int[] nums) {
        // go through the array
        // comparing the left cumulative sum
        // with the sum of all the elements of the array - left cumulative sum - current element (this equals right cumsum)
        // return the index of the first match
        
        int leftCumSum = 0;
        int rightCumSum = 0;
        int totalSum = 0;
        
        for (int element: nums) {
            totalSum += element;
        }
        
        for (int i = 0; i < nums.length; i++) {
            rightCumSum = totalSum - leftCumSum - nums[i];
            if (leftCumSum == rightCumSum ) return i;
            leftCumSum += nums[i];
        }
        return -1;
    }
}