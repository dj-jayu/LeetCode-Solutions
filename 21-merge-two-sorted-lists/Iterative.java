// name: Iterative.java
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
// Time: O(n + m) -> the decision making loop that requires a fixed number
// of read and reassigning operations happens one time for every node
// from both lists
// Space: O(1) -> We use the same number of intermediary variables independently of the 
// lists size

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // We will start chosing the head with the smaller value
        // as the decidingNode
        // The deciding node will always have to make a choice
        // between which node to point
        // it will always choose the available node with the smallest value
        // The available nodes will always be:
        // 1- the node pointed by the deciding node
        // 2- the smaller node from the list different from the deciding node's list
        
        // if both lists are empty, return a empty list
        if (list1 == null && list2 == null) {
            return null;
        }
        
        if (list1 == null && list2 != null) return list2;
        if (list1 != null && list2 == null) return list1;
        
        // the head to be returned
        ListNode returnNode;
        
        ListNode decidingNode;
        
        ListNode candidateNode1;
        
        ListNode candidateNode2;
        
        if (list1.val < list2.val) {
            decidingNode = list1;
            candidateNode1 = list2;
        } else {
            decidingNode = list2;
            candidateNode1 = list1;
        }
        
        returnNode = decidingNode;
        
        candidateNode2 = decidingNode.next;
        
        // Time: O(n + n)
        while (candidateNode1 != null && candidateNode2 != null) {
            if (candidateNode1.val < candidateNode2.val) {
                decidingNode.next = candidateNode1;
                decidingNode = candidateNode1;
                candidateNode1 = decidingNode.next;
            } else {
                decidingNode.next = candidateNode2;
                decidingNode = candidateNode2;
                candidateNode2 = decidingNode.next;
            }
        }
        
        decidingNode.next = candidateNode1 == null ? candidateNode2 : candidateNode1;
        
        return returnNode;
        
        
        
    }
}