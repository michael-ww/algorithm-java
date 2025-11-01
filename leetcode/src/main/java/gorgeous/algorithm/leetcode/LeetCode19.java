package gorgeous.algorithm.leetcode;

public class LeetCode19 {

    public ListNode<Integer> removeNthFromEnd(ListNode<Integer> head, int n) {
        ListNode<Integer> dummy = new ListNode<>(null);
        dummy.setNext(head);
        ListNode<Integer> fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.getNext();
        }
        ListNode<Integer> slow = dummy;
        while (fast != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        slow.setNext(slow.getNext().getNext());
        return dummy.getNext();
    }
}
