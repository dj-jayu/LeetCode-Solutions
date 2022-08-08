// name: AddNodesToSet.java
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
import java.util.Set;
import java.util.HashSet;

// Time: O(n) -> we iterate through all elements in the list
// Space: O(n) -> the set can be as big as the length of the list

public class Solution {
    public ListNode detectCycle(ListNode head) {
        // We add the nodes in a HashSet
        // first checking if the set already contains the node
        // and return the first node for which it's true
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        
        ListNode current = head;
        
        while (current != null) {
            if (nodeSet.contains(current)) return current;
            nodeSet.add(current);
            current = current.next;
        }
        return null;
    }
}