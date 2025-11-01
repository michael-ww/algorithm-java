package gorgeous.algorithm.leetcode;

public class LeetCode876 {

    public ListNode<Integer> middleNode(ListNode<Integer> head) {
        ListNode<Integer> fast = head, slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;
    }
}
