// name: ToTheEndAndHalf.java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Time: O(n) -> we move n + n/2 times
// Space: O(1) -> we use a fixed number of variables to hold temporary values independently of the list size
class Solution {
    public ListNode middleNode(ListNode head) {
        // we will go to the end of the list
        // counting the number of steps we took
        // then we start moving again from the beginning of the list
        // but these time we will move half the number of steps
    
        int steps = 0;
        ListNode current = head;
        
        // to the end
        while (current.next != null) {
            current = current.next;
            steps++;
        }
        
        steps = steps % 2 == 0 ? steps : steps + 1;
        steps /= 2;
        current = head;
        
        // coming back
        for (int i = 0; i < steps; i++) {
            current = current.next;
        }
        
        return current;
        
    }
}