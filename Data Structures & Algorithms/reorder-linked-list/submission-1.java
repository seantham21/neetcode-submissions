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

class Solution {
    public void reorderList(ListNode head) {
        // Find the middle node
        ListNode slow = head;
        ListNode fast = head;
        while ((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        } // slow is now the middle node

        // Reverse the second half
        // slow.next until null
        ListNode temp2 = slow;
        slow = slow.next;
        temp2.next = null;

        ListNode temp;
        ListNode prev = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        } // prev is head of reversed

        // Merge the two lists
        temp = head;
        while ((prev != null) && (head != null)) {
            temp2 = head.next;
            head.next = prev;
            fast = prev.next;
            prev.next = temp2;
            head = temp2;
            prev = fast;
        }
    }
}
