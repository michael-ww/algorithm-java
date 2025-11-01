package gorgeous.algorithm.leetcode;

public class LeetCode83 {

    public ListNode<Integer> deleteDuplicates(ListNode<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode<Integer> slow = head, fast = head;
        while (fast != null) {
            if (!slow.getValue().equals(fast.getValue())) {
                slow.setNext(fast);
                slow = slow.getNext();
            }
            fast = fast.getNext();
        }
        slow.setNext(null);
        return head;
    }
}
