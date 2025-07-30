package gorgeous.algorithm.leetcode;

import gorgeous.algorithm.common.ListNode;

public class LeetCode206 {

    public ListNode<Integer> reverseList(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode<Integer> previous = null, current = head;
        while (current != null) {
            ListNode<Integer> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }
}
