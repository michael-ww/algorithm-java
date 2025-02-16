package gorgeous.algorithm.leetcode;

import java.util.HashSet;

public class LeetCode141 {

    public boolean hasCycle1(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return false;
        }

        HashSet<ListNode<Integer>> hashSet = new HashSet<>();
        ListNode<Integer> current = head;
        while (current != null) {
            if (hashSet.contains(current)) {
                return true;
            } else {
                hashSet.add(current);
            }
            current = current.getNext();
        }

        return false;
    }

    public boolean hasCycle2(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        ListNode<Integer> fast = head, slow = head;
        while (fast != null && slow != null) {
            if (fast.getNext() == null || fast.getNext().getNext() == null) {
                return false;
            }
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
