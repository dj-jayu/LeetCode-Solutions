// 1-
// Nested loops and external array
// Time: Big(o) n2 (nested loop)
// Space: Big(o) n (same size as input array)

// class Solution {
//     public int[] runningSum(int[] nums) {
//         // we will create 2 loops to make the sums
//         // saving the results to a new array which we will return in the end
        
//         int[] runningSumArray = new int[nums.length];
        
//         for (int stopAtInclusive = 0; stopAtInclusive < nums.length; stopAtInclusive++) {
//             for (int i = 0; i <= stopAtInclusive; i++) {
//                 runningSumArray[stopAtInclusive] += nums[i];
//             }
//         }
        
//         return runningSumArray;
//     }
// }


// 2-
// One loop, external array
// Time: Big(o) n
// Space: Big(o) n

// class Solution {
//     public int[] runningSum(int[] nums) {
//         // we will sum walk through the array
//         // summing the current elements with the sum
//         // of the elements before
//         // saving the result in an external array
        
//         int[] runningSumArray = new int[nums.length];
        
//         int sumBeforeMe = 0;
        
//         for (int i = 0; i < nums.length; i++) {
//             if (i != 0) sumBeforeMe = runningSumArray[i - 1];
            
//             runningSumArray[i] = sumBeforeMe + nums[i];
//         }
        
//         return runningSumArray;
//     }
// }


// 3-
// One loop, same array
// Time: Big(o) n (one pass through the array)
// Space: Big(o) 1

class Solution {
    public int[] runningSum(int[] nums) {
        // We walk through the array
        // summing the current element with the sum of the elements before
        // we consider the 'zeroth' sum to be 0
        
        int sumBeforeMe = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) sumBeforeMe = nums[i - 1];
            nums[i] = sumBeforeMe + nums[i];
            
        }
        
        return nums;
    }
}