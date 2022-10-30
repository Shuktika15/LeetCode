package add_two_numbers;


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        int carry = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode fakeHead = new ListNode(0);
        ListNode p3 = fakeHead;

        while (p1 != null && p2 != null) {
            int digitSum = p1.val + p2.val + carry;
            p3.next = new ListNode(digitSum % 10);
            carry = digitSum / 10;
            p3 = p3.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int digitSum = p1.val + carry;
            p3.next = new ListNode(digitSum % 10);
            carry = digitSum / 10;
            p1 = p1.next;
            p3 = p3.next;
        }

        while (p2 != null) {
            int digitSum = p2.val + carry;
            p3.next = new ListNode(digitSum % 10);
            carry = digitSum / 10;
            p2 = p2.next;
            p3 = p3.next;
        }

        if (carry != 0) {
            p3.next = new ListNode(carry);
        }

        return fakeHead.next;
    }
}
