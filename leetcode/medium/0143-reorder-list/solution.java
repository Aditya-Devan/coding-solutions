// Step 1: Find the middle of the linked list using fast & slow pointers
// Step 2: Reverse the second half of the linked list
     // Disconnect the first half from the second half
// Step 3: Interleave/merge the first half and reversed second half

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

     
        ListNode curr = slow.next;
        slow.next = null; 
        ListNode prev = null;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        ListNode second = prev; 

        ListNode first = head;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }
}