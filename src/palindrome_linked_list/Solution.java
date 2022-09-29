package palindrome_linked_list;

class Solution {
    public ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            //update
            previous = current;
            current = next;
        }
        return previous;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middleNode = findMiddle(head);
        ListNode headNew = reverseLinkedList(middleNode);

        ListNode l1 = head;
        ListNode l2 = headNew;
        while (l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l2 = l2.next;
            l1 = l1.next;
        }
        return true;
    }
}
