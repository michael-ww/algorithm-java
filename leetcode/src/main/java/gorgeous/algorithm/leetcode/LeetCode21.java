package gorgeous.algorithm.leetcode;

public class LeetCode21 {

    public ListNode<Integer> mergeTwoLists1(ListNode<Integer> list1, ListNode<Integer> list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode<Integer> dummy = new ListNode<>(0);
        ListNode<Integer> current = null;
        dummy.setNext(current);
        while (list1 != null || list2 != null) {
            if (list1 == null || (list2 != null && list1.getValue() > list2.getValue())) {
                current = list2;
                list2 = list2.getNext();
            } else {
                current = list1;
                list1 = list1.getNext();
            }
            current = current.getNext();
        }

        return dummy.getNext();
    }

    public ListNode<Integer> mergeTowListNode2(ListNode<Integer> list1, ListNode<Integer> list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            if (list1.getValue() > list2.getValue()) {
                list2.setNext(this.mergeTowListNode2(list1, list2.getNext()));
                return list2;
            } else {
                list1.setNext(this.mergeTowListNode2(list1.getNext(), list2));
                return list1;
            }
        }
    }
}
