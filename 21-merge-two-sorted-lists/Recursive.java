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

// Time: O(n + m) where n is the size of list1 and m is the size of list2
// Space: O(n + m) -> we make one recursion call for every node from both lists
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // We return the smaller head (list1 or list2)
        
        // But first we merge the lists recursively:
        // Calling
        // mergeTwoLists(list1, list2[1:]) if list1 > list2
        // or
        // mergeTwoLists(list1[1:], list2) if list1 < list2
        
        // The base case is when one of the arguments is null
        // Then we return the other argument
        
        // The if's below could be simplified,
        // but writing they explicitly is better for understanding
        // all cases
        
        // if both lists are null
        if (list1 == null && list2 == null) return null;
        
        // Base cases: if one list is null but not the other
        // return the other
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list1 != null && list2 == null) {
            return list1;
        }
        
        // recursion
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
        
    }
}