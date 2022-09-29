package remove_nth_node_from_end_of_linked_list;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode dummy = head;
        while (dummy != null) {
            size++;
            dummy = dummy.next;
        }

        if (size == 1) {
            return null;
        }

        int position = size - n;
        dummy = head;

        if (position == 0) {
            return dummy.next;
        }
        for (int i = 0; i < position - 1; i++) {
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
        return head;

    }
}
