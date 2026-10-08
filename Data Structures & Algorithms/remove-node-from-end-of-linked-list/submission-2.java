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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // 1 2 3 4 5
        int remIndex = length - n;
        ListNode temp = head;
        ListNode prev = null;
        for (int i = 0; i < remIndex; i++) {
            prev = temp;
            temp = temp.next;
        }

        if (prev == null) {
            return head.next;
        } else {
            ListNode after = temp.next;
            temp.next = null;
            prev.next = after;
            return head;
        }
    }
}
