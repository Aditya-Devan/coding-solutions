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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
    
      ListNode mid=getMid(head);
      ListNode rightHead=mid.next;
      mid.next=null;

      ListNode newL=sortList(head);
      ListNode newR=sortList(rightHead);

      ListNode ans=merge(newL,newR);

      return ans;

    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; 
    }

     private ListNode merge(ListNode head1, ListNode head2) {
    
        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // If there are remaining nodes in head1
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        // If there are remaining nodes in head2
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        // Return the merged list, skipping the dummy node
        return mergedLL.next;
    }

}