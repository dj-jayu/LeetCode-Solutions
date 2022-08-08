// name: FastSlowPointers2.java
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

// Time: O(n) -> 2n -> 2 assigments in the while loop * n iterations of the while loop
// Space: O(1) -> constant number of auxiliary variables
class Solution {
    public ListNode middleNode(ListNode head) {
        // Both pointers start at the head
        // The fast moves 2 nodes forward
        // while the first moves 1 node forward
        
        ListNode faster = head;
        ListNode slower = head;
        
        // this is a simpler loop than the one in FastSlowPointers1.java
        while (faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            
        }
        return slower;
    }
}