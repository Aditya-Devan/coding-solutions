# Sort List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the `head` of a linked list, return  *the list after sorting it in  **ascending order***.

 

 **Example 1:** 

```
Input: head = [4,2,1,3]
Output: [1,2,3,4]

```

 **Example 2:** 

```
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

```

 **Example 3:** 

```
Input: head = []
Output: []

```

 

 **Constraints:** 

- The number of nodes in the list is in the range [0, 5 * 104].
- -105 <= Node.val <= 105

 

 **Follow up:**  Can you sort the linked list in `O(n logn)` time and `O(1)` memory (i.e. constant space)?

## Solution

**Language:** Java  
**Runtime:** 12 ms (beats 31.86%)  
**Memory:** 59.6 MB (beats 31.54%)  
**Submitted:** 2026-08-10T03:59:21.600Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/sort-list/)