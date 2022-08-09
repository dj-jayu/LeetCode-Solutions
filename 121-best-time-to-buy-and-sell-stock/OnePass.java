// name: OnePass.java

// Time: O(n) -> we iterate one time through the array
// Space: O(1) -> we use a constant number and size of auxiliary variables
// for any array length

class Solution {
    public int maxProfit(int[] prices) {
        // We iterate through the array one time
        // keeping track of the best profit 
        // and the best buy price until
        // the current element
        // When we see a new element
        // we consider if buying it would
        // give us a bigger profit
        // if yes we update the profit to be this value
        // later before moving to the next element
        // we see if the new element value is a better buy price
        // if it is, we update the best buy price
        
        int bestBuyPrice = Integer.MAX_VALUE;
        int bestDeal = Integer.MIN_VALUE;
        int dealCandidate = 0;
        
        for (int price: prices) {
            // check for best deal
            dealCandidate = (price - bestBuyPrice);
            if (dealCandidate > bestDeal) {
                bestDeal = dealCandidate;
            }
            
            // check for best buy price
            if (price < bestBuyPrice) {
                bestBuyPrice = price;
            }
        }
        // if we can't have a profit, return 0
        if (bestDeal < 0) return 0;
        return bestDeal;
    }
}