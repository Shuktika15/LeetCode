package reverse_linked_list;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prepointer = head;
        ListNode pointer = head.next;
        ListNode temp1 = null, temp2 = null;
        prepointer.next = null;
        while (pointer.next != null) {
            temp1 = prepointer;
            temp2 = pointer;
            prepointer = pointer;
            pointer = pointer.next;
            temp2.next = temp1;
        }
        temp1 = prepointer;
        temp2 = pointer;
        prepointer = pointer;
        pointer = pointer.next;
        temp2.next = temp1;
        return temp2;
    }
}
