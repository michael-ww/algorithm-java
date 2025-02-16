package gorgeous.algorithm.leetcode;

public class LeetCode142 {

    public ListNode<Integer> detectCycle(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return null;
        }
        ListNode<Integer> fast = head, slow = head;
        while (!fast.equals(slow)) {
            if (fast.getNext() == null || fast.getNext().getNext() == null) {
                return null;
            }
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        fast = head;
        while (!fast.equals(slow)) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return fast;
    }
}
