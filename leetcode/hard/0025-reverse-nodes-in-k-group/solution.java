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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {

            ListNode kth = prevGroupEnd;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break;

            // reverse k nodes
            ListNode groupStart = prevGroupEnd.next;
            ListNode curr = groupStart;
            ListNode prev = kth.next;

            for (int i = 0; i < k; i++) {
                ListNode nex = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nex;
            }

            // connect reversed group
            prevGroupEnd.next = prev;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }
}
