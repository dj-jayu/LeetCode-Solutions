// name: FastSlowPointers1.java
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
        
        // the middle of a null list is null
        if (head == null) return null;
        
        // the middle node of a list with only the head is the head
        if (head.next == null) return head;
        
        while (faster.next != null && faster.next.next != null) {
            faster = faster.next.next;
            slower = slower.next;
        }
        
        // if we are here, faster is either at the last node
        // and slower at the correct node
        // Or faster is at the second to last node
        // and slower needs to advance one node to be in the correct position
        
        if (faster.next == null) {
            return slower;
        }
        return slower.next;
    }
}