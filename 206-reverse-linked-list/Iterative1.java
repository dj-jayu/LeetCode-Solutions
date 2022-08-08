// name: Iterative1.java
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
        // if the next node is null, we reached the end of the list
        // so we reverse the last node and return it
        
        // if the head is null
        if (head == null) return null;
        
        ListNode current = head;
        ListNode previous = null;
        ListNode nextOfCurrent = current.next;
        
        while (nextOfCurrent != null) {
            // state: previous, current -> nextOfCurrent -> ...
            current.next = previous;
            // state: previous <- current, nextOfCurrent -> ...
            previous = current;
            current = nextOfCurrent;
            // state: oldPrevious<-previous, current -> ...
            nextOfCurrent = current.next;
            // state: oldPrevious<-previous, current -> nextCurrent -> ...
            // this last state is the same one from the beggining
            // of the loop
            // but we are one node ahead
            // so we start the loop again if nextOfCurrent is not null
        }
        // if we are here, current is the most right element
        // and all elements to the left of it were reversed
        // so the only thing left to do
        // is to reverse current and return it
        current.next = previous;
        return current;
        
    }
}