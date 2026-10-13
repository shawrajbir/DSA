class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find the end of first half using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half
        ListNode secondHalfHead = reverseList(slow.next);

        // 3. Check whether the list is a palindrome
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean isPalin = true;
        while (isPalin && p2 != null) {
            if (p1.val != p2.val) {
                isPalin = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4. Restore the original list
        slow.next = reverseList(secondHalfHead);

        return isPalin;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}