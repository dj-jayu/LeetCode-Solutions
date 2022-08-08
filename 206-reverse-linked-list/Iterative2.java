// name: Iterative2.java
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
// Time: O(n) -> we make constant time operations for every node in the list
// Space: O(1) -> we use a constant number of auxiliary variables independently of the
// list length

class Solution {
    public ListNode reverseList(ListNode head) {
        // Starting from the head
        // We call our head node as currentNode
        // We rearrange the pointers, reversing the list
        // node by node
        // if the current node is null, we reached the end of the list
        
        // if the head is null
        if (head == null) return null;
        
        ListNode current = head;
        ListNode previous = null;
        ListNode nextOfCurrent = null;
        
        while (current != null) {
            // state: previous, current -> ...
            nextOfCurrent = current.next;
            // state: previous, current -> nextOfCurrent
            current.next = previous;
            // state: previous <- current, nextOfCurrent -> ...
            previous = current;
            current = nextOfCurrent;
            // state: oldPrevious<-previous, current -> ...
        }
        // if we are here, previous is the most right element
        // it and all elements to it's right were reversed
        // so we return it
        return previous;   
    }
}