package gorgeous.algorithm.leetcode;

public class LeetCode19 {

    public ListNode<Integer> removeNthFromEnd(ListNode<Integer> head, int n) {
        ListNode<Integer> dummy = new ListNode<>(0);
        dummy.setNext(head);
        ListNode<Integer> fast = head;
        ListNode<Integer> slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.getNext();
        }
        while (fast != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        slow.setNext(slow.getNext().getNext());
        return dummy.getNext();
    }
}
