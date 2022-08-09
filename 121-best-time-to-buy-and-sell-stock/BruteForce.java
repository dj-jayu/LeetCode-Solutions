// name: BruteForce.java

// Time: O(n2) -> 1 nested loop -> (n - 1) + (n - 2) ... 1 = (n-1)(n)/2 = O(n2)
// Space: O(1) -> we use the same number and size of auxiliary variables for any
// input

class Solution {
    public int maxProfit(int[] prices) {
        // For each element of the array (except the last one)
        // we check the max profit that could be earned
        // if we would sell on each allowed day (forward)
        // We return the maximum value of all valid
        // combinations
        
        int maxProfit = Integer.MIN_VALUE;
        int dealCandidate = 0;
        
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                
                dealCandidate = prices[j] - prices[i];
                
                // if we have a better deal
                if (dealCandidate > maxProfit) {
                    // make it our deal
                    maxProfit = dealCandidate;
                }
            }
        }
        // (if we initialized dealCandidate as 0 we wouldn't need the below if)
        // if our best option is a loss, better to not make a deal
        if (maxProfit < 0) return 0;
        
        return maxProfit;
    }
}
