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
        ListNode second = slow.next;
        slow.next = null;

        ListNode temp;
        ListNode prev = null;
        while (second != null) {
            temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        } // prev is head of reversed

        // Merge the two lists
        ListNode nextHead;
        ListNode nextBack;
        while ((prev != null) && (head != null)) {
            nextHead = head.next;
            head.next = prev;
            nextBack = prev.next;
            prev.next = nextHead;
            head = nextHead;
            prev = nextBack;
        }
    }
}
