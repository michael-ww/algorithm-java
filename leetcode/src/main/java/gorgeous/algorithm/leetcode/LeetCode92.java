package gorgeous.algorithm.leetcode;

public class LeetCode92 {

    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        ListNode<Integer> dummy = new ListNode<>(null);
        dummy.setNext(head);
        ListNode<Integer> previous = dummy;
        for (int i = 0; i < left - 1; i++) {
            previous = previous.getNext();
        }

        ListNode<Integer> current = previous.getNext();
        for (int i = 0; i < right - left; i++) {
            ListNode<Integer> next = current.getNext();
            current.setNext(next.getNext());
            next.setNext(previous.getNext());
            previous.setNext(next);
        }

        return dummy.getNext();
    }
}
