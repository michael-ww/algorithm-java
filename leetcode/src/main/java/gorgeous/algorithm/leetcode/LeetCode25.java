package gorgeous.algorithm.leetcode;

public class LeetCode25 {

    public ListNode<Integer> reverseKGroup(ListNode<Integer> head, int k) {
        ListNode<Integer> dummy = new ListNode<Integer>(null, head);
        ListNode<Integer> previous = dummy;
        while (head != null) {
            ListNode<Integer> tail = previous;
            for (int i = 0; i < k; i++) {
                tail = tail.getNext();
                if (tail == null) {
                    return dummy.getNext();
                }
            }
            ListNode<Integer> next = tail.getNext();
            tail.setNext(null);
            previous.setNext(Utility.reverse(head));
            head.setNext(next);
            previous = head;
            head = next;

        }
        return dummy.getNext();
    }
}
