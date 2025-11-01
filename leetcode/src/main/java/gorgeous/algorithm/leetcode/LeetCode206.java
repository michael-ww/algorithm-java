package gorgeous.algorithm.leetcode;

public class LeetCode206 {

    public ListNode<Integer> reverseList(ListNode<Integer> head) {
        ListNode<Integer> previous = null, current = head, next = head.getNext();
        while (current != null) {
            current.setNext(previous);
            previous = current;
            current = next;
            if (next != null) {
                next = next.getNext();
            }
        }
        return previous;
    }
}
