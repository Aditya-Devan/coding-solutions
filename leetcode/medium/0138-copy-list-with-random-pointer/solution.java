class Solution {
     // -------- STEP 1: Interleave copied nodes --------
     // -------- STEP 2: Assign random pointers --------
     // -------- STEP 3: Separate the lists --------
             // restore original list
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;

        // -------- STEP 1: Interleave copied nodes --------
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // -------- STEP 2: Assign random pointers --------
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // -------- STEP 3: Separate the lists --------
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            Node copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copy;

            curr.next = copy.next; // restore original list
            curr = curr.next;
        }

        return dummy.next;
    }
}
