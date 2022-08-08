// name: HareAndTortoise.java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Time: O(n) -> We iterate one time through the list
// Space: O(1) -> The number and size of temporary variables are independent of the list size

public class Solution {
    private ListNode getIntersect(ListNode head) {
        // move tortoise (speed: 1 node/iteration) 
        // and hare (speed: 2 nodes/iteration)
        // until they find each other
        // and returns the node at which it happens
        
        ListNode tortoise = head;
        ListNode hare = head;
        
        // try to find the intersection node
        while (hare != null && hare.next != null) {            
            // hare is twice as fast than tortoise
            hare = hare.next.next;
            tortoise = tortoise.next;
            
            // if they find each other
            if (hare == tortoise) return hare;
        }
        // A acyclical list will break the while loop
        // For the while conditions
        // Hare being null means no cycle
        // Hare.next being null gives an 'index out of bounds error'
        // and also means no cycle
        return null;
    }
    
    public ListNode detectCycle(ListNode head) {
        // Searching for the Floyd's Tortoise and Hare
        // algorithm will give an explanation for the code below
        
        // an empty list returns null
        if (head == null) return null;
        
        
        ListNode intersect = getIntersect(head);
        
        // If the list is acyclical
        if (intersect == null) return null;
        
        // if we are here
        // we know for sure that hare and tortoise
        // are at the same node: intersect
        
        // Now we start a new pointer at the head
        // and walk it and tortoise by 1
        // until they find each other
        // the node where that happens
        // is the entrance to the cycle
        ListNode start = head;
        
        while (start != intersect) {
            intersect = intersect.next;
            start = start.next;
        }
        
        return start;
        
    }
}