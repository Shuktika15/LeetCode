package intersection_of_two_linked_lists;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode p1 = a;
        ListNode p2 = b;
        while (p1 != p2) {
            p1 = p1 != null ? p1.next : b;
            p2 = p2 != null ? p2.next : a;
        }
        return p1;
    }
}
