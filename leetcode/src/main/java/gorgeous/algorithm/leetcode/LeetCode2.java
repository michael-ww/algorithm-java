package gorgeous.algorithm.leetcode;

import java.util.Optional;

public class LeetCode2 {

    public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode<Integer> dummy = new ListNode<>(0);
        ListNode<Integer> current = dummy;
        int carryNumber = 0;
        while (l1 != null || l2 != null) {
            int x = Optional.ofNullable(l1).map(ListNode::getValue).orElse(0);
            int y = Optional.ofNullable(l2).map(ListNode::getValue).orElse(0);
            int z = x + y + carryNumber;
            current.setNext(new ListNode<>(z % 10));
            carryNumber = z / 10;
            current = current.getNext();
            if (l1 != null) {
                l1 = l1.getNext();
            }
            if (l2 != null) {
                l2 = l2.getNext();
            }
        }

        if (carryNumber > 0) {
            current.setNext(new ListNode<>(carryNumber));
        }
        return dummy.getNext();
    }
}
