package gorgeous.algorithm.leetcode;

import java.util.HashSet;

public class LeetCode141 {

    public boolean hasCycle1(ListNode<Integer> head) {
        HashSet<ListNode<Integer>> set = new HashSet<>();
        ListNode<Integer> current = head;
        while (current != null) {
            if (set.contains(current)) {
                return true;
            } else {
                set.add(current);
            }
            current = current.getNext();
        }

        return false;
    }

    public boolean hasCycle2(ListNode<Integer> head) {
        ListNode<Integer> fast = head, slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
