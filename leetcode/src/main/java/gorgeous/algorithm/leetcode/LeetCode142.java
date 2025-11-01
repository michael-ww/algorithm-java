package gorgeous.algorithm.leetcode;

public class LeetCode142 {

    public ListNode<Integer> detectCycle(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return null;
        }
        ListNode<Integer> fast = head, slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.getNext() == null) {
            return null;
        }

        slow = head;
        while (fast != slow) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return fast;
    }
}
