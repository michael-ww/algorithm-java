package gorgeous.algorithm.leetcode;

import gorgeous.algorithm.common.ListNode;

public class LeetCode21 {

    public ListNode<Integer> mergeTowListNode(ListNode<Integer> list1, ListNode<Integer> list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            if (list1.getValue() > list2.getValue()) {
                list2.setNext(this.mergeTowListNode(list1, list2.getNext()));
                return list2;
            } else {
                list1.setNext(this.mergeTowListNode(list1.getNext(), list2));
                return list1;
            }
        }
    }
}
