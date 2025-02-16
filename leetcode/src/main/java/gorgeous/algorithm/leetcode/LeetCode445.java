package gorgeous.algorithm.leetcode;

public class LeetCode445 {

    public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        l1 = Utility.reverse(l1);
        l2 = Utility.reverse(l2);

        ListNode<Integer> dummy = new ListNode<>(null);
        ListNode<Integer> current = dummy;
        Integer carryNumber = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.getValue();
            int y = l2 == null ? 0 : l2.getValue();
            int z = x + y + carryNumber;
            current.setNext(new ListNode<>(z % 10));
            current = current.getNext();
            carryNumber = z / 10;
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

        return Utility.reverse(dummy.getNext());
    }
}
