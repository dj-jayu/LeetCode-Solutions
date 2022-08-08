// name: Recursive.java
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
// Time: O(n) -> each recursive call makes a constant time operation
// Space: O(n) -> we make n recursive calls, so the call stack could be n levels deep

class Solution {
    public ListNode reverseList(ListNode head) {
        // From the viewpoint of the head
        // to get the whole list reversed
        // it needs to return itself pointing
        // to the last element of the reversed list that excludes itself
    
        // The base case is when the head is the only element of the list
        // in this case we return the head,
        // or when the head is null
        // in which case we return null
        
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;
        
        // recursion:
        
        // p points to the beginning of the reversed list 
        ListNode p = reverseList(head.next);
        
        // but head is pointing in the wrong way
        // it still points in the original direction
        // state: head -> nodeX (nodeX points to null) <- ... <- node2 <- node1 <- p
        // so we need to correct it
        head.next.next = head;
        // state: head -> <- nodeX <- ... <- node2 <- node1 <- p
        head.next = null;
        // state: null <- head <- nodeX <- ... <- node2 <- node1 <- p
        
        return p;
    }
}